package com.proyecto.mvc.models;

import java.time.LocalDate;
import java.time.Period;

public class Empleado {
	private int id;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String rol;
	
	public Empleado(String nombre, LocalDate fechaNacimiento, String rol) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.rol = rol;
		this.id = -1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int calcularEdad() {
	    LocalDate hoy = LocalDate.now();
	    return Period.between(this.fechaNacimiento, hoy).getYears();
	}
}
