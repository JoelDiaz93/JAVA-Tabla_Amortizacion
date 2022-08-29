package com.cmc.evaluacion.servicios;

import com.cmc.evaluacion.commonc.TipoAmortizacion;
import com.cmc.evaluacion.entidades.Prestamo;

public class TestCalculadora2 {
	public static void main(String[] args) {
		Prestamo prestamo = new Prestamo(500000, 12, 15,"A1234");
		CalculadoraAmortizacion.generarTabla(prestamo,TipoAmortizacion.FRANCESA);
		CalculadoraAmortizacion.mostrarTabla(prestamo);
	}
}
