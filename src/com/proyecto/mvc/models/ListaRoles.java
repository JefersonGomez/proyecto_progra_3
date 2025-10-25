package com.proyecto.mvc.models;

import java.util.ArrayList;

public class ListaRoles {

	private ArrayList<Rol> listaRoles;
	private int id;

	public ListaRoles() {
		listaRoles = new ArrayList<>();
		id = 1;
	}

	// metodo para meter en la lista nuevos roles
	public void store(Rol item) {
		item.setId(id++);
		listaRoles.add(item);
	}

	// metodo para editar se busca un rol con ese id
	public void update(Rol item, int id) {

		for (int i = 0; i < listaRoles.size(); i++) {

			if (listaRoles.get(i).getId() == id) {

				item.setId(id);
				listaRoles.set(i, item);
				break;
			}

		}

	}

	// metodo para eliminar con un id
	public void delete(int id) {

		for (int i = 0; i < listaRoles.size(); i++) {

			if (listaRoles.get(i).getId() == id) {

				listaRoles.remove(i);
				break;
			}

		}
	}

	//metodo para obtener un objeto Rol
	public Rol getItem(int id) {

		Rol r = null;

		for (Rol roles : listaRoles) {
			if (roles.getId() == id) {
				r = roles;
			}
		}
		return r;
	}
//metodos de la tabla 
	
	public String[] getColumns() {
		return new String[] {"ID","NOMBRE","SALARIO"};
	}
	
	public Object[][] getData1(){
		Object data[][] = new Object[listaRoles.size()][getColumns().length];
		
		int i =0;
		
		for (Rol roles : listaRoles) {
			
			data[i][0] = roles.getId();
			data[i][1]= roles.getNombreRol();
			data[i][2]= roles.getSalario();
			
			i++;
		}
		
		return data;
	}
	
	
	
	public Rol buscarPorNombre(String nombreRol) {
	    for (Rol r : listaRoles) {
	        if (r.getNombreRol().equalsIgnoreCase(nombreRol)) {
	            return r;
	        }
	    }
	    return null; // si no lo encuentra
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
