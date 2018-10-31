package controller;

import java.io.IOException;

import negocio.Empleado;

public class Test {
	public static void main(String[] args) {
		Empleado e = new Empleado(1,"Profe", "Jorge", "Segio", "Dir", "Mail", "+5411123", 50);
		try {
			new Post(e);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
