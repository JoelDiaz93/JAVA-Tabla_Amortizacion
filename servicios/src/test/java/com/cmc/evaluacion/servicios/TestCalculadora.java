package com.cmc.evaluacion.servicios;

import com.cmc.evaluacion.commonc.TipoAmortizacion;
import com.cmc.evaluacion.entidades.Prestamo;

public class TestCalculadora {
	public static void main(String[] args) {
		Prestamo prestamo = new Prestamo(5000, 12, 12, "A123");
		CalculadoraAmortizacion.generarTabla(prestamo,TipoAmortizacion.FRANCESA);
		CalculadoraAmortizacion.mostrarTabla(prestamo);
	}
}
