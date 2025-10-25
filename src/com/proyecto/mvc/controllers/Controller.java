package com.proyecto.mvc.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.proyecto.mvc.models.Empleado;
import com.proyecto.mvc.models.ListaEmpleados;
import com.proyecto.mvc.models.ListaRoles;
import com.proyecto.mvc.models.Rol;
import com.proyecto.mvc.views.Form;
import com.proyecto.mvc.views.FormRol;
import com.proyecto.mvc.views.Index;
import com.proyecto.mvc.views.IndexReporte;
import com.proyecto.mvc.views.IndexRol;
import com.proyecto.mvc.views.ViewPrincipal;

public class Controller extends Functions {

	private ViewPrincipal view;
	private ListaEmpleados lista;
	private ListaRoles listaRoles;
	private IndexReporte Reporte;
	public Controller() {
		view = new ViewPrincipal();
		lista = new ListaEmpleados();
		listaRoles = new ListaRoles();
		Reporte = new IndexReporte();

		cargarTabla();
		tablaPrueba();
		view();
		indexRol();
		metodosReportes();
		index();
	}

	public void cargarTabla() {
		lista.store(new Empleado("Daniel", LocalDate.of(2004, 11, 29), "Gerente"));
		lista.store(new Empleado("Yeik", LocalDate.of(2005, 07, 15), "Administrador"));
		lista.store(new Empleado("Alejandro", LocalDate.of(2005, 11, 06), "TI"));
		lista.store(new Empleado("Isaac", LocalDate.of(2005, 06, 01), "Supervisor"));
		lista.store(new Empleado("Gerarda", LocalDate.of(2007, 10, 27), "Trabajador"));
		lista.store(new Empleado("Genaro", LocalDate.of(2004, 02, 8), "Depurador"));
		lista.store(new Empleado("Amanda", LocalDate.of(2004, 03, 21), "Recursos Humanos"));
		lista.store(new Empleado("Jeferson", LocalDate.of(2004, 10, 11), "Gerente"));
		lista.store(new Empleado("Olito Bonito", LocalDate.of(2000, 04, 15), "CEO"));
		lista.store(new Empleado("Daniel2", LocalDate.of(2002, 06, 1), "Administrador"));
	}

	public void view() {
		view.btnEmpleados.addActionListener(e -> {
			index();
		});

		view.btnRoles.addActionListener(e -> {
			indexRol();
		});
		
		view.btnReportes.addActionListener(e->{
			indexReporte();
		});
	}

	public void index() {
		Index index = new Index();
		view.setContenido(index);
		index.model.setDataVector(lista.getData(), lista.getColumns());

		// ACCIONES BOTONES
		index.btnNuevo.addActionListener(e -> {
			panelAgregar();
		});

		index.btnEditar.addActionListener(e -> {
			int idEditar = getSelectedID(index.table);
			if (idEditar == 0) {
				JOptionPane.showMessageDialog(view, "Ninguna fila seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				panelEditar(idEditar);
			}
		});

		index.btnEliminar.addActionListener(e -> {
			int idEliminar = getSelectedID(index.table);
			if (idEliminar == 0) {
				JOptionPane.showMessageDialog(view, "Ninguna fila seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				lista.delete(idEliminar);
				index();
			}
		});

		index.textField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String buscar = index.textField.getText();
				buscar(index.table, buscar, 0, 1, 2, 3, 4, 5);
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

	}

	public void panelAgregar() {
		Form form = new Form();
		view.setContenido(form);
		
		form.comboBox.removeAllItems();
	    Object[][] rolesData = listaRoles.getData1();
	    
	    for (Object[] fila : rolesData) {
	        form.comboBox.addItem((String) fila[1]); // Agregar cada rol directamente
	    }
		
		form.btnGuardar.addActionListener(e->{
			String nombre = form.textField.getText().trim();
			String auxFecha = form.textField_1.getText().trim();
			String rol = (String) form.comboBox.getSelectedItem();
			
			if(nombre.isEmpty() || form.textField_1.getText().isEmpty()|| auxFecha.isEmpty()) {
				
				JOptionPane.showMessageDialog(view, "Debe llenar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(!validarFormatoFecha(auxFecha)) {
				JOptionPane.showMessageDialog(view, "Formato de fecha inválido. Use yyyy-MM-dd", "Error", JOptionPane.ERROR_MESSAGE);
				form.textField_1.setText("");
	            return;
			}
			
			LocalDate fecha = LocalDate.parse(auxFecha);
			
			lista.store(new Empleado(nombre, fecha, rol));
			JOptionPane.showMessageDialog(view, "Empleado agregado correctamente.", "Completado", JOptionPane.INFORMATION_MESSAGE);
			index();
		});
		
		view.btnEmpleados.addActionListener(e->{
			index();
		});
		form.btnEliminar.addActionListener(e->{
			index();
		});
	}

	public void panelEditar(int idEditar) {
		Form form = new Form();
		form.btnEliminar.setVisible(true);
		view.setContenido(form);

		Empleado aux = lista.getItem(idEditar);
		
		form.comboBox.removeAllItems();
	    Object[][] rolesData = listaRoles.getData1();
	    
	    for (Object[] fila : rolesData) {
	        form.comboBox.addItem((String) fila[1]); // Agregar cada rol directamente
	    }

		form.textField.setText(aux.getNombre());
		form.textField_1.setText(aux.getFechaNacimiento().toString());
		form.comboBox.setSelectedItem(aux.getRol());

		form.btnGuardar.addActionListener(e -> {
			String nombre = form.textField.getText().trim();
			String auxFecha = form.textField_1.getText().trim();
			String rol = (String) form.comboBox.getSelectedItem();

			if (nombre.isEmpty() || form.textField_1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(view, "Debe llenar todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(!validarFormatoFecha(auxFecha)) {
				JOptionPane.showMessageDialog(view, "Formato de fecha inválido. Use YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
			}
			
			LocalDate fecha = LocalDate.parse(auxFecha);

			lista.update(new Empleado(nombre, fecha, rol), idEditar);
			JOptionPane.showMessageDialog(view, "Solicitud editada correctamente.", "Completado",
					JOptionPane.INFORMATION_MESSAGE);
			index();
		});

		form.btnEliminar.addActionListener(e -> {
			destroyEmpleado(idEditar);
			index();
		});

		/*
		 * view.btnEmpleados.addActionListener(e->{ index(); });
		 */
	}
	
	// metodos de validacion de fecha
	
	private boolean validarFormatoFecha(String fecha) {
	    //para validar formato YYYY-MM-DD
	    String regex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";
	    
	    if (!fecha.matches(regex)) {
	        return false;
	    }
	        LocalDate.parse(fecha);
	        return true;
	}
	
	//metodo de eliminacion
	
	public void destroyEmpleado(int id) {

		if (id > 0) {

			int confimar = JOptionPane.showConfirmDialog(view, "Desea eliminar el registro");

			if (confimar == JOptionPane.OK_OPTION) {

				lista.delete(id);
				index();
			}
		} else {
			JOptionPane.showMessageDialog(view, "Debe seleccinar un empleado antes.", "Error de eliminacion",JOptionPane.ERROR_MESSAGE);
		}
	}
	

	public void indexRol() {
		IndexRol v = new IndexRol();
		view.setContenido(v);
		v.model.setDataVector(listaRoles.getData1(), listaRoles.getColumns());

		v.btnNuevo.addActionListener(e -> {
			agregarRol();
		});

		v.btnEditar.addActionListener(e -> {
			int id = getSelectedID(v.table);
			
			if (id == 0) {
				JOptionPane.showMessageDialog(view, "Ninguna fila seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				editRol(id);
			}

		});

		v.btnEliminar.addActionListener(e -> {
			int id = getSelectedID(v.table);
			
			if (id == 0) {
				JOptionPane.showMessageDialog(view, "Ninguna fila seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				
				listaRoles.delete(id);
				indexRol();
			}
			
		});

		v.tBuscar.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {

				String buscar = v.tBuscar.getText();

				buscar(v.table, buscar, 1, 2);

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void agregarRol() {
		FormRol f = new FormRol();
		view.setContenido(f);

		f.btnGuardar.addActionListener(e -> {

			String nombre = f.txtNombre.getText().trim();
			String salarioVali = f.txtSalario.getText();

			if (nombre.isEmpty() || salarioVali.isEmpty()) {
				JOptionPane.showMessageDialog(view, "Debe llenar todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				
				double salario = Double.parseDouble(salarioVali);

				listaRoles.store(new Rol(nombre, salario));
				JOptionPane.showMessageDialog(view, "Rol guardado con exito.", "Completado",
						JOptionPane.INFORMATION_MESSAGE);
				indexRol();
			}

		});

		f.btnEliminarF.addActionListener(e -> {
			indexRol();
		});
	}

	public void editRol(int id) {
		FormRol f = new FormRol();
		f.btnEliminarF.setVisible(true);
		view.setContenido(f);

		Rol rolAux = listaRoles.getItem(id);

		f.txtNombre.setText(rolAux.getNombreRol());
		f.txtSalario.setText(String.valueOf(rolAux.getSalario()));

		f.btnGuardar.addActionListener(e -> {

			String nombre = f.txtNombre.getText();
			String salarioVali = f.txtSalario.getText();

			if (nombre.isEmpty() || salarioVali.isEmpty()) {
				JOptionPane.showMessageDialog(view, "Debe llenar todos los campos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				double salario = Double.parseDouble(salarioVali);

				listaRoles.update(new Rol(nombre, salario), id);
				JOptionPane.showMessageDialog(view, "Rol editado con exito.", "Completado",
						JOptionPane.INFORMATION_MESSAGE);
				indexRol();
			}

		});

		f.btnEliminarF.addActionListener(e -> {
			destroyRol(id);
		});

	}
	
	public void destroyRol(int id) {

		if (id > 0) {

			int confElimar = JOptionPane.showConfirmDialog(view, "Desea eliminar el registro");

			if (confElimar == JOptionPane.OK_OPTION) {

				listaRoles.delete(id);
				indexRol();
			}
		} else {
			JOptionPane.showMessageDialog(view, "Debe seleccinar un rol antes.", "Error de eliminacion",JOptionPane.ERROR_MESSAGE);
		}
	}

	
	
	public void indexReporte() {
		
		view.setContenido(Reporte);
		
		
	}

	public void tablaPrueba() {
		listaRoles.store(new Rol("Recursos Humanos", 500000));
		listaRoles.store(new Rol("Gerente", 195000));
		listaRoles.store(new Rol("Trabajador", 80000));
		listaRoles.store(new Rol("Supervisor", 12000));
		listaRoles.store(new Rol("Administrador", 150000));
		listaRoles.store(new Rol("CEO", 1000000));
		listaRoles.store(new Rol("Depurador", 300000));
		listaRoles.store(new Rol("TI", 450000));
	}
	
	public void metodosReportes() {
	    Reporte.btnBuscar.addActionListener(e -> {
	    	//System.out.print("Click");
	        String r = Reporte.selecionCombobox();
	        String dato = Reporte.txtCriterioBusqueda.getText();

	        // limpiar tabla antes de mostrar resultados nuevos
	        Reporte.model.setRowCount(0);

	        switch (r) {
	            case "Empleados por edades":
	                try {
	                    int edadMax = Integer.parseInt(dato);

	                    for (Empleado p : lista.getListaEmpleados()) {
	                        int edadEmpleado = p.calcularEdad();
	                        if (edadEmpleado <= edadMax) {
	                            // Buscar el rol en ListaRoles
	                            Rol rolObj = listaRoles.buscarPorNombre(p.getRol());
	                            double salario = (rolObj != null) ? rolObj.getSalario() : 0;

	                            Reporte.model.addRow(new Object[]{
	                                p.getNombre(),
	                                p.getFechaNacimiento(),
	                                p.getRol(), // nombre del rol
	                                salario
	                            });
	                        }
	                    }
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Ingrese una edad válida");
	                }
	                break;

	            case "Empleados por salario":
	                try {
	                    double salarioMax = Double.parseDouble(dato);

	                    for (Empleado p : lista.getListaEmpleados()) {
	                        Rol rolObj = listaRoles.buscarPorNombre(p.getRol());
	                        double salario = (rolObj != null) ? rolObj.getSalario() : 0;

	                        if (salario <= salarioMax) {
	                            Reporte.model.addRow(new Object[]{
	                                p.getNombre(),
	                                p.getFechaNacimiento(),
	                                p.getRol(),
	                                salario
	                            });
	                        }
	                    }
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(view, "Ingrese un salario válido");
	                }
	                break;
	                
	            case "Empleados por rol":
	            	try {
	            		System.out.print("entro");
	            		for(Empleado p : lista.getListaEmpleados()) {
	            			 Rol rolObj = listaRoles.buscarPorNombre(p.getRol());
	            			if(p.getRol().equalsIgnoreCase(dato)) {
	            				Reporte.model.addRow(new Object[]{
		                                p.getNombre(),
		                                p.getFechaNacimiento(),
		                                p.getRol(),
		                                rolObj.getSalario()
		                            });
	            			}
	            			
	            			
	            		}
	            		
	            		
	            	}catch (Exception ex) {
	            		 JOptionPane.showMessageDialog(view, "Ingrese un salario válido");
					}
	            	
	            	break;
	            default:
	                JOptionPane.showMessageDialog(view, "Seleccione un tipo de reporte válido");
	                break;
	        }
	    });
	}


		
	

}
