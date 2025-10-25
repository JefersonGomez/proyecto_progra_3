package com.proyecto.mvc.views;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormRol extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public JTextField txtNombre;
	public JTextField txtSalario;
	public JButton btnEliminarF;
	public JButton btnGuardar;

	public FormRol() {
		setLayout(null);
		setBackground(new Color(0xEAF2F8)); 
		setBorder(new EmptyBorder(20, 20, 20, 20));

		Font labelFont = new Font("Arial", Font.BOLD, 13);
		Font fieldFont = new Font("Arial", Font.PLAIN, 12);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(39, 86, 155, 22);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(labelFont);
		lblNombre.setForeground(new Color(0x2C3E50));
		lblNombre.setBounds(40, 50, 120, 20);
		add(lblNombre);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(labelFont);
		lblSalario.setForeground(new Color(0x2C3E50));
		lblSalario.setBounds(40, 120, 120, 20);
		add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(39, 159, 155, 22);
		add(txtSalario);
		txtSalario.setColumns(10);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuardar.setBounds(40, 210, 120, 35);
		btnGuardar.setBackground(new Color(0x4CAF50));
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setFocusPainted(false);
		add(btnGuardar);

		btnEliminarF = new JButton("ELIMINAR");
		btnEliminarF.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminarF.setBounds(180, 210, 120, 35);
		btnEliminarF.setBackground(new Color(0xC0392B));
		btnEliminarF.setForeground(Color.BLACK);
		btnEliminarF.setFocusPainted(false);
		btnEliminarF.setVisible(false);
		add(btnEliminarF);
	}
	
}