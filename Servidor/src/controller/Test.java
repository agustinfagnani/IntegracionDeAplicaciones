package controller;

import org.json.JSONException;
import exception.SistemaLiquidacionException;
import integracion.PostTarjeta;
import negocio.Alumno;
import negocio.Credito;
import negocio.Deposito;
<<<<<<< HEAD
import negocio.Empleado;
import negocio.Escolaridad;
=======
>>>>>>> master
import negocio.Factura;
import negocio.Titular;

public class Test {
	public static void main(String[] args){
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
	
	
}
}
