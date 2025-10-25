package com.proyecto.mvc.models;

import java.util.ArrayList;

public class ListaEmpleados {
	private ArrayList<Empleado> listaEmpleados;
	private int id;
	
	public ListaEmpleados() {
		this.listaEmpleados = new ArrayList<>();
		this.id = 1;
	}
	
	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void store(Empleado item) {
		item.setId(id++);
		listaEmpleados.add(item);
	}

	public void update(Empleado item, int id) {

		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getId() == id) {
				item.setId(id);
				listaEmpleados.set(i, item);
				break;
			}
		}

	}

	public void delete(int id) {
		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getId() == id) {
				listaEmpleados.remove(i);
				break;
			}
		}
	}

	public Empleado getItem(int id) {
		Empleado aux = null;
		
		for (Empleado temp : listaEmpleados) {
			if (temp.getId() == id) {
				aux = temp;
			}
		}
		
		return aux;
	}
	
	public String[] getColumns() {
		return new String[] {"ID", "NOMBRE", "FECHA NACIMIENTO", "ROL"};
	}
	
	public Object[][] getData(){
		Object data[][] = new Object[listaEmpleados.size()][getColumns().length];
		int i =0;
		
		for (Empleado temp : listaEmpleados) {
			data[i][0] = temp.getId();
			data[i][1] = temp.getNombre();
			data[i][2] = temp.getFechaNacimiento();
			data[i][3] = temp.getRol();
			
			i++;
		}
		
		return data;
	}
	
}
