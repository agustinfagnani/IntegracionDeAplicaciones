package integracion;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import exception.SistemaLiquidacionException;
import negocio.Credito;
import negocio.Deposito;
import negocio.Empleado;
import negocio.Factura;
import negocio.Titular;

public class PostTarjeta {

	private final String  NROESCUELA = "NROESTABLECIMIENTO";
	private final String  IP = "192.168.157.77:8090";

	public PostTarjeta(Factura factura) throws SistemaLiquidacionException, JSONException {
		JSONObject json = new JSONObject();
		Date fechaConsumo  =new Date();
		fechaConsumo = Date.from(factura.getFechaEmision().atZone(ZoneId.systemDefault()).toInstant());

		json.accumulate("idEstablecimiento", NROESCUELA);// NroEstablecimiento
		json.accumulate("codigoSeguridad", ((Credito)factura.getTitular().getTipoDePago()).getCodSeg());
		json.accumulate("fechaConsumo", fechaConsumo);
		json.accumulate("descripcion", "Escuela cuota: " 
		                               +"Número de Factura: "
		                               +factura.getNumero()
		                               +" - Periodo: "+factura.getPeriodo()+" - "+factura.getAnio());
		json.accumulate("monto", new BigDecimal(factura.getCostoTotal()));


		System.out.println(json.toString());


		StringEntity entity;
		try {
			entity = new StringEntity(json.toString());
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost(IP+"/tarjetas/"+((Credito)factura.getTitular().getTipoDePago()).getNumeroTarjeta()+"/consumosEnteros");
			request.setHeader("Accept", "application/json");
			request.setHeader("Content-type", "application/json");
			request.setEntity(entity);

			HttpResponse response = httpClient.execute(request);
			System.out.println(response.getStatusLine().getStatusCode());
			if(response.getStatusLine().getStatusCode() != 201) {
				System.out.println(response.getStatusLine().getStatusCode());
				throw new SistemaLiquidacionException();
			}
		} catch (IOException e) {
			throw new SistemaLiquidacionException();
		}



	}
}

