package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EntradaVista extends JPanel {

    private JButton jbDemanar = new JButton();
    private JButton jbReserva = new JButton();
    private JPanel panel = new JPanel();

    public EntradaVista () {

        SpringLayout sl_panel = new SpringLayout();
        panel.setLayout(sl_panel);

        JPanel panel_1 = new JPanel();
        sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 63, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, panel_1, 44, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -35, SpringLayout.SOUTH, panel);
        sl_panel.putConstraint(SpringLayout.EAST, panel_1, 378, SpringLayout.WEST, panel);
        panel.add(panel_1);
        panel_1.setLayout(null);

        jbDemanar.setText("DEMANAR");
        jbDemanar.setBounds(0, 0, 162, 103);
        panel_1.add(jbDemanar);

        jbReserva.setText("RESERVAR");
        jbReserva.setBounds(163, 0, 171, 103);
        panel_1.add(jbReserva);

        JLabel label = new JLabel("LS_RESTAURANT");
        sl_panel.putConstraint(SpringLayout.NORTH, label, 22, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, label, 163, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, label, -19, SpringLayout.NORTH, panel_1);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

    }

    public JPanel getPanel(){
        return panel;
    }

    public void registraControlador(ActionListener controller) {         //Registro els botons
        jbReserva.addActionListener(controller);
        jbDemanar.addActionListener(controller);
        jbReserva.setActionCommand("RESERVAR");
        jbDemanar.setActionCommand("DEMANAR");
    }
}
