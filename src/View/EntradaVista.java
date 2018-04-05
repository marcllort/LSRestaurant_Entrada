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

        JPanel jpMain = Borders(jpCentre);       //Creem el JPanel principal

        getContentPane().add(jpMain);

    }

    private JPanel Centre(){
        JPanel jpCentre = new JPanel();

        jpCentre.setLayout(new BoxLayout(jpCentre, BoxLayout.PAGE_AXIS));

        //Creem els butons i els alineem

        jbDemanar.setText("DEMANAR");
        jbDemanar.setAlignmentX(SwingConstants.CENTER);
        jbReserva.setText("RESERVAR");
        jbReserva.setAlignmentX(SwingConstants.CENTER);

        //Els afegim

        jpCentre.add(jbDemanar);
        jpCentre.add(jbReserva);

        return jpCentre;
    }

    private JPanel Borders(JPanel jpCentre){
        JPanel jpMain = new JPanel();

        jpMain.setLayout(new BorderLayout());

        //Creem el titol
        JLabel jlTitol = new JLabel("LS Restaurant");
        jlTitol.setHorizontalTextPosition(SwingConstants.CENTER);

        //Afegim el titol i el panell anterior al JPanel principal
        jpMain.add(jlTitol, BorderLayout.NORTH);
        jpMain.add(jpCentre, BorderLayout.CENTER);

        return jpMain;
    }



}
