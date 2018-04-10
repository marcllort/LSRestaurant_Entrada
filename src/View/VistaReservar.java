package View;

import javax.swing.*;
import java.awt.*;

public class VistaReservar extends JPanel{

    private static final int MAX_COMENSALS = 15;
    private JTextField jtfUsuari = new JTextField();
    private JTextField jtfDia = new JTextField();
    private JTextField jtfMes = new JTextField();
    private JTextField jtfAny = new JTextField();
    private JComboBox<String> jcbHores = new JComboBox<>();
    private JComboBox<String> jcbComensals = new JComboBox<>();
    private JButton jbReservar = new JButton();

    public VistaReservar () {

        JPanel jpMain = Reserva();       //Creem el JPanel principal

        this.add(jpMain);

    }

    private JPanel Reserva() {

        JPanel jpReserva = new JPanel();

        jpReserva.setLayout(new BoxLayout(jpReserva, BoxLayout.PAGE_AXIS));

        JLabel jlTitol = new JLabel("LS RESTAURANT");

        jpReserva.add(jlTitol);

        jpReserva.add(usuari());
        jpReserva.add(dia());
        jpReserva.add(hora());
        jpReserva.add(comensals());
        jbReservar.setText("Reservar");
        jpReserva.add(jbReservar);

        return jpReserva;
    }

    private JPanel comensals() {
        JPanel jpComensals = new JPanel();

        jpComensals.setLayout(new GridLayout(1,2));

        jpComensals.add(new JLabel("Comensals: "));

        for(Integer i = 1; i <= MAX_COMENSALS; i++) {
            jcbComensals.addItem(i.toString());
        }

        jpComensals.add(jcbComensals);

        return jpComensals;
    }

    private JPanel hora() {
        JPanel jpHora = new JPanel();

        jpHora.setLayout(new GridLayout(1,2));

        jpHora.add(new JLabel("Hora: "));

        //ComboBox Horas
        jcbHores.addItem("13:00");
        jcbHores.addItem("14:30");
        jcbHores.addItem("19:30");
        jcbHores.addItem("21:30");

        jpHora.add(jcbHores);

        return jpHora;
    }

    private JPanel dia() {
        JPanel jpDia = new JPanel();

        jpDia.setLayout(new GridLayout(1,6));

        jpDia.add(new JLabel("Dia: "));
        jpDia.add(jtfDia);
        jpDia.add(new JLabel("/"));
        jpDia.add(jtfMes);
        jpDia.add(new JLabel("/"));
        jpDia.add(jtfAny);

        return jpDia;
    }

    private JPanel usuari() {
        JPanel jpUsu = new JPanel();

        jpUsu.setLayout(new GridLayout(1,2));

        jpUsu.add(new JLabel("Usuari: "));

        jpUsu.add(jtfUsuari);

        return jpUsu;
    }


}
