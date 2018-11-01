package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {
	public static void main(String[] args){
		/*
// JSON
// {"monto":0,"nroFactura":0,"fechaFactura":"2018-11-01T09:16:48.244","cbuOrigen":"1122334455667788990011","cbuDestino":"1122334455667788990011"}	
	Titular titular = new Titular("titular1", 123123, "dire", "mail", "tel", new Credito("1111222233334444", 111));
	Escolaridad e = new Escolaridad("t", 123);
	Alumno alumno1 = new Alumno("Juan Perez", "Su Casa", "mail@aa.com","4256575", e);
	titular.addAlumno(alumno1);
	Factura factura  = new Factura(titular, 01, 2018);
	try {
//		PostBanco banco = new PostBanco(factura);
		PostTarjeta tarjeta = new PostTarjeta(factura);
	} catch (SistemaLiquidacionException | JSONException el) {
		// TODO Auto-generated catch block
		el.printStackTrace();
	}	
	
	*/
		
	Properties prop = new Properties();
	FileOutputStream output = null;

	try {

		output = new FileOutputStream("direcciones.properties");

		// set the properties value
		prop.setProperty("ipBanco", "192.168.x.x");
		prop.setProperty("ipTarjeta", "http://192.168.43.130:8090");
		prop.setProperty("ipPresentismo", "192.168.215.224");
		prop.setProperty("urlLiquidacion", "https://sueldosya.herokuapp.com/employee");
		// save properties to project root folder
		prop.store(output, null);

	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
}
