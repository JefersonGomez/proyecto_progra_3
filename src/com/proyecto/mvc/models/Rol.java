package com.proyecto.mvc.models;

public class Rol {
	
	private int id;
	private String nombreRol;
	private double salario;
	
	public Rol(String nombreRol, double salario) {
		this.nombreRol = nombreRol;
		this.salario = salario;
		this.id=-1;
	}
	
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Roles [nombreRol=" + nombreRol + ", salario=" + salario;
	}
	
	
}
