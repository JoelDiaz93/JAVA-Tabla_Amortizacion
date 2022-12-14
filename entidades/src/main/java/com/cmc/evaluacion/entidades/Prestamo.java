package com.cmc.evaluacion.entidades;

import java.util.Arrays;

import com.cmc.evaluacion.commonc.Utilitario;

public class Prestamo {
	private double monto;
	private double interes;
	private int plazo;
	private String codigo;
	private Cuota[] cuotas;
	private double totalItereses;

	public Prestamo(double monto, double interes, int plazo, String codigo) {
		this.codigo = codigo;
		this.monto = monto;
		this.interes = interes;
		this.plazo = plazo;
		this.cuotas = new Cuota[plazo];
	}

	public double getMonto() {
		return monto;
	}

	public double getInteres() {
		return interes;
	}

	public int getPlazo() {
		return plazo;
	}

	public Cuota[] getCuotas() {
		return cuotas;
	}

	public String getCodigo() {
		return codigo;
	}

	public double getTotalItereses() {
		return totalItereses;
	}

	public void setTotalItereses(double totalItereses) {
		this.totalItereses = totalItereses;
	}

}
