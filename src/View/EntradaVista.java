package View;

import javax.swing.*;
import java.awt.*;

public class EntradaVista extends JFrame {

    private JButton jbDemanar = new JButton();
    private JButton jbReserva = new JButton();

    public EntradaVista () {
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("DPO-1718-LSRestaurant-Entrada");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jpCentre = Centre();      //Creem el panell central

        getContentPane().setLayout(new BorderLayout());

        //Creem el titol
        JLabel jlTitol = new JLabel("LS RESTAURANT");
        jlTitol.setHorizontalTextPosition(SwingConstants.CENTER);

        //Afegim el titol i el panell anterior al JPanel principal
        getContentPane().add(jlTitol, BorderLayout.NORTH);
        getContentPane().add(jpCentre, BorderLayout.CENTER);

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


}
