package View;

import javax.swing.*;
import java.awt.*;

public class VistaReservar extends JFrame{

    private JTextField jtfUsuari = new JTextField();
    private JTextField jtfDia = new JTextField();
    private JTextField jtfMes = new JTextField();
    private JTextField jtfAny = new JTextField();
    private JComboBox<String> hores = new JComboBox<>();
    private JTextField jtfComensals = new JTextField();

    public VistaReservar () {
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("DPO-1718-LSRestaurant-Entrada");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jpMain = Reserva();       //Creem el JPanel principal

        getContentPane().add(jpMain);

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

        return jpReserva;
    }

    private JPanel comensals() {
        JPanel jpComensals = new JPanel();

        jpComensals.setLayout(new GridLayout(1,2));

        jpComensals.add(new JLabel("Comensals: "));
        jpComensals.add(jtfComensals);

        return jpComensals;
    }

    private JPanel hora() {
        JPanel jpHora = new JPanel();

        jpHora.setLayout(new GridLayout(1,2));

        jpHora.add(new JLabel("Hora: "));

        //ComboBox Horas
        hores.addItem("13:00");
        hores.addItem("14:30");
        hores.addItem("19:30");
        hores.addItem("21:30");

        jpHora.add(hores);

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
