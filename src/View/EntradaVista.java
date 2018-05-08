package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EntradaVista extends JPanel {

    private JButton jbDemanar;
    private JButton jbReserva;
    private JPanel panel = new JPanel();

    /**
     * Constructor creador de la vista entrada, que disposa dels 2 botons demanar i reservar
     */

    public EntradaVista () {

        SpringLayout sl_panel = new SpringLayout();
        panel.setLayout(sl_panel);

        JPanel panel_1 = new JPanel();
        sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 106, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, panel_1, 123, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -83, SpringLayout.SOUTH, panel);
        sl_panel.putConstraint(SpringLayout.EAST, panel_1, 457, SpringLayout.WEST, panel);
        panel.add(panel_1);
        panel_1.setLayout(null);

        jbDemanar = new JButton("DEMANAR");
        jbDemanar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jbDemanar.setBounds(0, 0, 162, 110);
        panel_1.add(jbDemanar);

        jbReserva = new JButton("RESERVAR");
        jbReserva.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jbReserva.setBounds(163, 0, 171, 110);
        panel_1.add(jbReserva);

        JLabel label = new JLabel("LS RESTAURANT");
        sl_panel.putConstraint(SpringLayout.NORTH, label, 35, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, label, -6, SpringLayout.NORTH, panel_1);
        sl_panel.putConstraint(SpringLayout.EAST, label, -170, SpringLayout.EAST, panel);
        label.setFont(new Font("Tahoma", Font.BOLD, 28));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

    }

    /**
     * Getter del panell Entrada
     * @return vistaEntrada
     */

    public JPanel getPanel(){
        return panel;
    }

    /**
     * Registra tots els botons amb el controlador per tal que l'ActionListener els detecti
     * @param controller
     */

    public void registraControlador(ActionListener controller) {         //Registro els botons
        jbReserva.addActionListener(controller);
        jbDemanar.addActionListener(controller);
        jbReserva.setActionCommand("RESERVAR");
        jbDemanar.setActionCommand("DEMANAR");
    }
}
