package com.proyecto.mvc.views;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class Form extends JPanel {
    public JTextField textField;
    public JTextField textField_1;
    public JButton btnGuardar;
    public JButton btnEliminar;
    public JComboBox comboBox;

    public Form() {
    	
        setLayout(null);
        setBackground(new Color(0xEAF2F8)); 
        setBorder(new EmptyBorder(20, 20, 20, 20));

        Font labelFont = new Font("Arial", Font.BOLD, 13);
        Font fieldFont = new Font("Arial", Font.PLAIN, 12);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(66, 51, 120, 20);
        lblNombre.setFont(labelFont);
        lblNombre.setForeground(new Color(0x2C3E50));
        add(lblNombre);

        textField = new JTextField();
        textField.setBounds(66, 80, 220, 30);
        textField.setFont(fieldFont);
        textField.setBackground(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(new Color(0xBDC3C7)));
        add(textField);

        JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento (yyyy-MM-dd):");
        lblFechaNacimiento.setBounds(66, 120, 220, 20);
        lblFechaNacimiento.setFont(labelFont);
        lblFechaNacimiento.setForeground(new Color(0x2C3E50));
        add(lblFechaNacimiento);

        textField_1 = new JTextField();
        textField_1.setBounds(66, 150, 220, 30);
        textField_1.setFont(fieldFont);
        textField_1.setBackground(Color.WHITE);
        textField_1.setBorder(BorderFactory.createLineBorder(new Color(0xBDC3C7)));
        add(textField_1);

        JLabel lblRol = new JLabel("Rol:");
        lblRol.setBounds(66, 190, 120, 20);
        lblRol.setFont(labelFont);
        lblRol.setForeground(new Color(0x2C3E50));
        add(lblRol);

        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(66, 280, 120, 35);
        btnGuardar.setBackground(new Color(0x4CAF50));
        btnGuardar.setForeground(Color.black);
        btnGuardar.setFocusPainted(false);
        add(btnGuardar);

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(200, 280, 120, 35);
        btnEliminar.setBackground(new Color(0xC0392B)); 
        btnEliminar.setForeground(Color.black);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setVisible(false);
        add(btnEliminar);
        
        comboBox = new JComboBox();
        comboBox.setBounds(66, 223, 220, 30);
        comboBox.setFont(fieldFont);
        comboBox.setBackground(Color.WHITE);
        comboBox.setBorder(BorderFactory.createLineBorder(new Color(0xBDC3C7)));
        add(comboBox);
    }
}

