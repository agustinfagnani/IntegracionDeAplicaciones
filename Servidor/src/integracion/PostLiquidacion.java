package integracion;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import exception.SistemaLiquidacionException;
import negocio.Empleado;

public class PostLiquidacion {

	public PostLiquidacion(Empleado em) throws SistemaLiquidacionException, JSONException {
		
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("direcciones.properties");

			// load a properties file
			prop.load(input);
		}
		catch(Exception e){
			
		}
			
		String url = prop.getProperty("urlLiquidacion");
		String clientId = prop.getProperty("clientIdLiquidacion");
		
		JSONObject json = new JSONObject();

		json.accumulate("address", "Default Value");
		json.accumulate("birth_date", "Default Value");
		json.accumulate("dni", em.getDNI());
		json.accumulate("payroll_type", "monthly");
		json.accumulate("gross_salary", em.getSalario());
		json.accumulate("salary_per_hour", null);
		json.accumulate("estimated_hours", null);
		json.accumulate("deductions", 17);
		json.accumulate("name", em.getNombre() + " " + em.getApellido());
		json.accumulate("client_id", clientId);
		json.accumulate("cbu", em.getCBU());


		System.out.println(json.toString());


		StringEntity entity;
		try {
			entity = new StringEntity(json.toString());
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost(url);
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
