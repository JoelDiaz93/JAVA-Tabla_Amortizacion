package com.cmc.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cmc.evaluacion.commonc.TipoAmortizacion;
import com.cmc.evaluacion.entidades.Cuota;
import com.cmc.evaluacion.entidades.Prestamo;
import com.cmc.evaluacion.entidades.PrestamoSimulacion;
import com.cmc.evaluacion.servicios.CalculadoraAmortizacion;

@Path("/prestamos")
public class banco {

	@Path("/test")
	@GET
	public String metodo() {
		return "Correcto";
	}

	@Path("/simulacion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response simularPrestamo(PrestamoSimulacion prestamoSim) {
		Prestamo prestamo = new Prestamo(prestamoSim.getMonto(), prestamoSim.getInteres(), prestamoSim.getPlazo(),
				"A1235");
		double intereses = 0;
		// Determino tipo de amortizacion
		if (prestamoSim.getTipo().equals("FR")) {
			CalculadoraAmortizacion.generarTabla(prestamo, TipoAmortizacion.FRANCESA);
		} else if (prestamoSim.getTipo().equals("AL")) {
			CalculadoraAmortizacion.generarTabla(prestamo, TipoAmortizacion.ALEMANA);
		}

		// Interes
		for (Cuota cuota : prestamo.getCuotas()) {
			intereses += cuota.getInteres();
		}

		System.out.println(intereses);
		CalculadoraAmortizacion.mostrarTabla(prestamo);
		return Response.status(200).entity(prestamo.getCuotas()).build();
	}

}
