package com.proyecto.mvc.views;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Index extends JPanel {
    public DefaultTableModel model;
    public JTable table;
    public JTextField textField;
    public JButton btnEliminar;
    public JButton btnEditar;
    public JButton btnNuevo;

    public Index() {
        setBackground(new Color(0xEAF2F8)); 
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(new BorderLayout(15, 15));

       
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x2C3E50));
        panel.setPreferredSize(new Dimension(10, 50));
        panel.setLayout(new BorderLayout(10, 0));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(panel, BorderLayout.NORTH);

        JLabel lblBuscar = new JLabel("BUSCAR:");
        lblBuscar.setForeground(Color.WHITE);
        lblBuscar.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblBuscar, BorderLayout.WEST);

        textField = new JTextField();
        textField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panel.add(textField, BorderLayout.CENTER);

       
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new EmptyBorder(10, 20, 10, 20));
        panel_2.setPreferredSize(new Dimension(10, 60));
        panel_2.setLayout(new GridLayout(1, 3, 20, 10));
        panel_2.setBackground(new Color(0xEAF2F8));
        add(panel_2, BorderLayout.SOUTH);

        btnNuevo = new JButton("+ NUEVO");
        btnNuevo.setBackground(new Color(0x4CAF50)); 
        btnNuevo.setForeground(Color.black);
        btnNuevo.setFocusPainted(false);
        panel_2.add(btnNuevo);

        btnEditar = new JButton("EDITAR");
        btnEditar.setBackground(new Color(0x2980B9)); 
        btnEditar.setForeground(Color.black);
        btnEditar.setFocusPainted(false);
        panel_2.add(btnEditar);

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBackground(new Color(0xC0392B)); 
        btnEliminar.setForeground(Color.black);
        btnEliminar.setFocusPainted(false);
        panel_2.add(btnEliminar);

        // ----- Tabla -----
        model = new DefaultTableModel(
            new Object[][] {
                {"1", "Producto A", "Disponible"},
                {"2", "Producto B", "Agotado"},
                {"3", "Producto C", "Disponible"},
            },
            new String[] {"ID", "Nombre", "Estado"}
        );

        table = new JTable(model);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 12));

        table.getTableHeader().setBackground(new Color(0x2C3E50));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));

        table.setSelectionBackground(new Color(0x2980B9));
        table.setSelectionForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);
    }
}
