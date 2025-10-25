package com.proyecto.mvc.views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ViewPrincipal extends JFrame {
    private JPanel contentPane;
    public JButton btnEmpleados;
    public JButton btnReportes;
    private JPanel panelCambiante;
    public JButton btnRoles;

    public ViewPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 720, 720);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(0xEAF2F8));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(170, 10));
        panel.setBackground(new Color(0x2C3E50));
        contentPane.add(panel, BorderLayout.WEST);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setPreferredSize(new Dimension(10, 200));
        panel_1.setBackground(new Color(0x2C3E50));
        panel.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new GridLayout(3, 1, 5, 10));

        btnEmpleados = new JButton("EMPLEADOS");
        btnEmpleados.setBackground(new Color(0x2980B9));
        btnEmpleados.setForeground(Color.WHITE);
        btnEmpleados.setFocusPainted(false);
        panel_1.add(btnEmpleados);

        btnRoles = new JButton("ROLES");
        btnRoles.setBackground(new Color(0x16A085));
        btnRoles.setForeground(Color.WHITE);
        btnRoles.setFocusPainted(false);
        panel_1.add(btnRoles);

        btnReportes = new JButton("REPORTES");
        btnReportes.setBackground(new Color(0x4CAF50));
        btnReportes.setForeground(Color.WHITE);
        btnReportes.setFocusPainted(false);
        panel_1.add(btnReportes);

        panelCambiante = new JPanel();
        panelCambiante.setBackground(Color.WHITE);
        contentPane.add(panelCambiante, BorderLayout.CENTER);
        panelCambiante.setLayout(new BorderLayout(0, 0));

        setVisible(true);
    }

    public void setContenido(JComponent c) {
        panelCambiante.removeAll();
        panelCambiante.add(c);
        panelCambiante.repaint();
        panelCambiante.revalidate();
    }
}
