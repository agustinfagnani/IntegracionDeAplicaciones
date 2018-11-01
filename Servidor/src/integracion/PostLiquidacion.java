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
import negocio.Empleado;

public class PostLiquidacion {

	//curl -X POST https://sueldosya.herokuapp.com/employee -H 'Content-Type: application/json' -D {BODY}
	/*{
    "address": "Casa Esclavo1",
    "birth_date": "11 de Noviembre",
    "dni": "38745192",
    "payroll_type": "monthly"|"per hour",
    "gross_salary": 75,
    "salary_per_hour": null,
    "estimated_hours": null,
    "deductions": 17,
    "name": "Esclavo1"
}
	 */
	public PostLiquidacion(Empleado em) throws SistemaLiquidacionException, JSONException {
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
		json.accumulate("client_id", "5bda09821592f30021b80684");
		json.accumulate("cbu", em.getCBU());


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
