package integracion;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import exception.SistemaLiquidacionException;
import negocio.Deposito;
import negocio.Empleado;
import negocio.Factura;
import negocio.Titular;

public class PostBanco {


	public PostBanco(Factura factura) throws SistemaLiquidacionException, JSONException {
		JSONObject json = new JSONObject();

		json.accumulate("cbuDestino", "1122334455667788990011");// CBU Escuela
		json.accumulate("cbuOrigen", ((Deposito)(factura.getTitular().getTipoDePago())).getCBU());
		json.accumulate("monto", factura.getCostoTotal());
		json.accumulate("nroFactura", factura.getNumero());
		json.accumulate("fechaFactura", factura.getFechaEmision());
		
		System.out.println(json.toString());


		StringEntity entity;
		try {
			entity = new StringEntity(json.toString());
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost("https://sueldosya.herokuapp.com/employee");
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

