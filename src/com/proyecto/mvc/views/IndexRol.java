package com.proyecto.mvc.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class IndexRol extends JPanel {

    private static final long serialVersionUID = 1L;

    // Campo de búsqueda
    public JTextField tBuscar;

    // Botones de acción
    public JButton btnNuevo;
    public JButton btnEditar;
    public JButton btnEliminar;

    // Tabla
    public DefaultTableModel model;
    public JTable table;
    private JScrollPane scrollPane;

    public IndexRol() {
        // Fondo general del panel
        setBackground(new Color(0xEAF2F8));
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(new BorderLayout(15, 15));

        // --- Barra superior de búsqueda ---
        JPanel barra = new JPanel(new BorderLayout(10, 0));
        barra.setBackground(new Color(0x2C3E50));
        barra.setPreferredSize(new Dimension(10, 50));
        barra.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(barra, BorderLayout.NORTH);

        JLabel lblBuscar = new JLabel("BUSCAR ROL:");
        lblBuscar.setForeground(Color.WHITE);
        lblBuscar.setFont(new Font("Arial", Font.BOLD, 14));
        barra.add(lblBuscar, BorderLayout.WEST);

        tBuscar = new JTextField();
        tBuscar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        barra.add(tBuscar, BorderLayout.CENTER);

        // --- Panel inferior con botones ---
        JPanel botones = new JPanel(new GridLayout(1, 3, 20, 10));
        botones.setBorder(new EmptyBorder(5, 5, 5, 5));
        botones.setBackground(new Color(0xEAF2F8));
        add(botones, BorderLayout.SOUTH);

        btnNuevo = new JButton("+ NUEVO");
        btnNuevo.setBackground(new Color(0x4CAF50));
        btnNuevo.setForeground(Color.BLACK);
        btnNuevo.setFocusPainted(false);
        botones.add(btnNuevo);

        btnEditar = new JButton("EDITAR");
        btnEditar.setBackground(new Color(0x2980B9));
        btnEditar.setForeground(Color.BLACK);
        btnEditar.setFocusPainted(false);
        botones.add(btnEditar);

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBackground(new Color(0xC0392B));
        btnEliminar.setForeground(Color.BLACK);
        btnEliminar.setFocusPainted(false);
        botones.add(btnEliminar);

        // --- Tabla ---
        model = new DefaultTableModel(
                new Object[][]{
                        {"1", "Administrador"},
                        {"2", "Empleado"},
                        {"3", "Invitado"},
                },
                new String[]{"ID", "Rol"}
        );

        table = new JTable(model);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        table.getTableHeader().setBackground(new Color(0x2C3E50));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        table.setSelectionBackground(new Color(0x2980B9));
        table.setSelectionForeground(Color.WHITE);

        scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);
    }
}
