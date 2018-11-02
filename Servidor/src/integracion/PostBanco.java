package integracion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import exception.SistemaBancoException;
import negocio.Deposito;
import negocio.Factura;

public class PostBanco {
	



	public PostBanco(Factura factura) throws SistemaBancoException {
		
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("direcciones.properties");

			// load a properties file
			prop.load(input);
		}
		catch(Exception e){
			
		}
			
		String IP = prop.getProperty("ipBanco");
		
		JSONObject json = new JSONObject();

		
		try {
			json.accumulate("destino", "1122334455667788990011");// CBU Escuela
			json.accumulate("origen", ((Deposito)(factura.getTitular().getTipoDePago())).getCBU());
			json.accumulate("monto", new BigDecimal(factura.getCostoTotal()));
			json.accumulate("descripcion", "Escuela cuota: " 
			        +"Nro de Factura: "
			        +factura.getNumero()
			        +" - Periodo: "+factura.getPeriodo()+" - "+factura.getAnio());

			json.accumulate("fecha", factura.getFechaEmision().toLocalDate());
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		json.accumulate("fecha", factura.getFechaEmision());
		
		System.out.println(json.toString());


		StringEntity entity;
		try {
			entity = new StringEntity(json.toString(), "UTF-8");
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost(IP+"/api/transferencia");
			request.setHeader("Accept", "application/json");
			request.setHeader("Content-type", "application/json");
			request.setEntity(entity);

			HttpResponse response = httpClient.execute(request);
			System.out.println(response.getStatusLine().getStatusCode());
			if(response.getStatusLine().getStatusCode() != 201) {
				System.out.println(response.getStatusLine().getStatusCode());
				throw new SistemaBancoException();
			}
		} catch (IOException e) {
			throw new SistemaBancoException();
		}



	}
}

