package com.cmc.evaluacion.servicios;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.cmc.evaluacion.entidades.Cliente;
import com.cmc.evaluacion.entidades.Prestamo;

import exceptions.DuplicatedException;
import exceptions.NotFoundException;

public class TestPrestamos {

	@Test
	public void testClienteNoExiste() {
		Banco b=new Banco();
		try {
			b.registrarCliente(new Cliente("1714616123", "Camilo", "Cuesta"));
			b.registrarCliente(new Cliente("0514616123", "Ramiro", "Cuesta"));
			b.asignarPrestamo("12334324", new Prestamo(1000,12, 18, "A1234"));
		} catch (DuplicatedException e) {
			e.printStackTrace();
		}catch(NotFoundException e){
			e.printStackTrace();
			assertEquals("no es cliente del banco", e.getMessage());
		}
	}
	
	@Test
	public void testVariosPrestamos() {
		Banco b=new Banco();
		try {
			b.registrarCliente(new Cliente("1714616123", "Camilo", "Cuesta"));
			b.registrarCliente(new Cliente("0514616123", "Ramiro", "Cuesta"));
			b.asignarPrestamo("0514616123", new Prestamo(1000,12, 18, "A1234"));
			b.asignarPrestamo("0514616123", new Prestamo(5000,15, 24, "A1234"));
			b.asignarPrestamo("1714616123", new Prestamo(3000,15, 24, "A1234"));
		} catch (DuplicatedException e) {
			e.printStackTrace();
		}catch(NotFoundException e){
			e.printStackTrace();
		}
		ArrayList<Prestamo> prestamos=b.buscarPrestamos("0514616123");
		assertEquals(2,prestamos.size());
	}
	
	@Test
	public void testNoTienePrestamos() {
		Banco b=new Banco();
		try {
			b.registrarCliente(new Cliente("1714616123", "Camilo", "Cuesta"));
			b.registrarCliente(new Cliente("0514616123", "Ramiro", "Cuesta"));
			b.asignarPrestamo("0514616123", new Prestamo(1000,12, 18, "A1234"));
			b.asignarPrestamo("0514616123", new Prestamo(5000,15, 24, "A1234"));
			b.asignarPrestamo("1714616123", new Prestamo(3000,15, 24, "A1234"));
		} catch (DuplicatedException e) {
			e.printStackTrace();
		}catch(NotFoundException e){
			e.printStackTrace();
		}
		ArrayList<Prestamo> prestamos=b.buscarPrestamos("123");
		assertEquals(null,prestamos);
	}
	
	@Test
	public void testValoresPrestamos() {
		Banco b=new Banco();
		try {
			b.registrarCliente(new Cliente("1714616123", "Camilo", "Cuesta"));
			b.registrarCliente(new Cliente("0514616123", "Ramiro", "Cuesta"));
			b.asignarPrestamo("0514616123", new Prestamo(1000,12, 18, "A1234"));
			b.asignarPrestamo("0514616123", new Prestamo(5000,15, 24, "A1234"));
			b.asignarPrestamo("1714616123", new Prestamo(3000,15, 24, "A1234"));
		} catch (DuplicatedException e) {
			e.printStackTrace();
		}catch(NotFoundException e){
			e.printStackTrace();
		}
		ArrayList<Prestamo> prestamos=b.buscarPrestamos("0514616123");
		assertEquals(2,prestamos.size());
		assertEquals(1000,prestamos.get(0).getCuotas()[0].getCapitalInicio(),0.01);
		assertEquals(0,prestamos.get(1).getCuotas()[23].getSaldo(),0.01);
	}
}
