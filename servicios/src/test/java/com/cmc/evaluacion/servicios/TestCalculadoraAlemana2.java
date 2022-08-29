package com.cmc.evaluacion.servicios;

import com.cmc.evaluacion.commonc.TipoAmortizacion;
import com.cmc.evaluacion.entidades.Prestamo;

public class TestCalculadoraAlemana2 {
	public static void main(String[] args) {
		Prestamo prestamo = new Prestamo(50000, 2, 12, "A1234");
		CalculadoraAmortizacion.generarTabla(prestamo, TipoAmortizacion.ALEMANA);
		CalculadoraAmortizacion.mostrarTabla(prestamo);
	}
}
