package com.proyecto.mvc.views;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class IndexReporte extends JPanel {

    private static final long serialVersionUID = 1L;

    public JTextField txtCriterioBusqueda;
    public JButton btnBuscar;
    public JComboBox<String> cbxCriterio;

    public DefaultTableModel model;
    public JTable table;

    public IndexReporte() {
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(245, 245, 245));

        // Panel superior (filtros)
        JPanel panelSuperior = new JPanel(new GridBagLayout());
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelSuperior.setBackground(new Color(255, 255, 255));
        add(panelSuperior, BorderLayout.NORTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta "Tipo de reporte"
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblTipo = new JLabel("Tipo de reporte:");
        lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
        panelSuperior.add(lblTipo, gbc);

        // ComboBox
        cbxCriterio = new JComboBox<>(new String[]{
                "Empleados por edades",
                "Empleados por salario",
                "Empleados por rol"
        });
        cbxCriterio.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelSuperior.add(cbxCriterio, gbc);

        // Etiqueta "Criterio de búsqueda"
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lblCriterio = new JLabel("Criterio de búsqueda:");
        lblCriterio.setFont(new Font("Tahoma", Font.BOLD, 14));
        panelSuperior.add(lblCriterio, gbc);

        // Campo de texto
        txtCriterioBusqueda = new JTextField();
        txtCriterioBusqueda.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelSuperior.add(txtCriterioBusqueda, gbc);

        // Botón buscar con estilo
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(0x2980B9));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFocusPainted(false);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panelSuperior.add(btnBuscar, gbc);

        // Modelo de tabla
        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nombre", "Nacimiento", "Rol", "Salario"}
        );

        // Tabla con estilo
        table = new JTable(model);
        table.setRowHeight(25);
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));
        table.setSelectionBackground(new Color(0x2980B9));
        table.setSelectionForeground(Color.WHITE);
        table.getTableHeader().setBackground(new Color(0x2C3E50));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Resultados"));
        add(scrollPane, BorderLayout.CENTER);
    }

    public String selecionCombobox() {
        return (String) this.cbxCriterio.getSelectedItem();
    }
}

