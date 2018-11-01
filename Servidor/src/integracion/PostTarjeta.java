package integracion;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
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

	private final String  NROESCUELA = "11";
	private final String  IP = "http://192.168.43.130:8090";

	public PostTarjeta(Factura factura) throws SistemaLiquidacionException, JSONException {
		JSONObject json = new JSONObject();
		json.accumulate("idEstablecimiento", NROESCUELA);// NroEstablecimiento
		json.accumulate("codigoSeguridad", ((Credito)factura.getTitular().getTipoDePago()).getCodSeg());
		json.accumulate("fecha", factura.getFechaEmision().toLocalDate());
		json.accumulate("descripcion", "Escuela cuota: " 
		                               +"Número de Factura: "
		                               +factura.getNumero()
		                               +" - Periodo: "+factura.getPeriodo()+" - "+factura.getAnio());
		json.accumulate("monto", new BigDecimal(factura.getCostoTotal()));

		System.out.println(json.toString());
		String link = IP+"/tarjetas/"+((Credito)factura.getTitular().getTipoDePago()).getNumeroTarjeta()+"/consumosEnteros";


		StringEntity entity;
		try {
			entity = new StringEntity(json.toString(), "UTF-8");
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost(link);

			request.setHeader("Accept", "application/json");
			request.setHeader("Content-type", "application/json");
			request.setEntity(entity);

			HttpResponse response = httpClient.execute(request);
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(response);

		} catch (IOException e) {
			throw new SistemaLiquidacionException();
		}

		

	}
}

