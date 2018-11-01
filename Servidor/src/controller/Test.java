package controller;

import java.io.IOException;

import org.json.JSONException;

import exception.SistemaLiquidacionException;
import integracion.PostBanco;
import negocio.Deposito;
import negocio.Empleado;
import negocio.Factura;
import negocio.TipoDePago;
import negocio.Titular;

public class Test {
	public static void main(String[] args){
// JSON
// {"monto":0,"nroFactura":0,"fechaFactura":"2018-11-01T09:16:48.244","cbuOrigen":"1122334455667788990011","cbuDestino":"1122334455667788990011"}	
	Titular titular = new Titular("titular1", 123123, "dire", "mail", "tel", new Deposito("1122334455667788990011"));
	Factura factura  = new Factura(titular, 01, 2018);
	try {
		PostBanco banco = new PostBanco(factura);
	} catch (SistemaLiquidacionException | JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}
}
