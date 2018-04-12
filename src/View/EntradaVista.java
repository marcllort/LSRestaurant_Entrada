package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EntradaVista extends JPanel {

    private JButton jbDemanar = new JButton();
    private JButton jbReserva = new JButton();

    public EntradaVista () {


        JPanel jpCentre = Centre();      //Creem el panell central

        this.setLayout(new BorderLayout());

        //Creem el titol
        JLabel jlTitol = new JLabel("LS RESTAURANT");
        jlTitol.setHorizontalTextPosition(SwingConstants.CENTER);

        //Afegim el titol i el panell anterior al JPanel principal
        this.add(jlTitol, BorderLayout.NORTH);
        this.add(jpCentre, BorderLayout.CENTER);

        jpCentre.setAlignmentX(SwingConstants.CENTER);
        jlTitol.setAlignmentX(SwingConstants.CENTER);

    }

    private JPanel Centre(){
        JPanel jpCentre = new JPanel();

        jpCentre.setLayout(new BoxLayout(jpCentre, BoxLayout.PAGE_AXIS));

        //Creem els butons i els alineem

        jbDemanar.setText("DEMANAR");
        jbReserva.setText("RESERVAR");

        //Els afegim

        jpCentre.add(jbDemanar);
        jpCentre.add(jbReserva);

        jbDemanar.setAlignmentX(SwingConstants.CENTER);
        jbReserva.setAlignmentX(SwingConstants.CENTER);
        jpCentre.setAlignmentX(SwingConstants.CENTER);

        return jpCentre;
    }

    public void registraControlador(ActionListener controller) {         //Registro els botons
        jbReserva.addActionListener(controller);
        jbDemanar.addActionListener(controller);
        jbReserva.setActionCommand("RESERVAR");
        jbDemanar.setActionCommand("DEMANAR");
    }
}
