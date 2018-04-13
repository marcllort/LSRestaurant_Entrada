package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;

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

    protected JPanel usuari() {
        JPanel jpUsu = new JPanel();

        jpUsu.setLayout(new GridLayout(1,2));

        jpUsu.add(new JLabel("Usuari: "));

        jpUsu.add(jtfUsuari);

        return jpUsu;
    }


    public void registraControlador(ActionListener controller) {

        jbReservar.addActionListener(controller);
        jbReservar.setActionCommand("NovaReserva");

    }

    public String getTypedUser (){
        return jtfUsuari.getText();
    }

    public Integer getTypedDateAny (){

        return Integer.parseInt(jtfAny.getText());

    }

    public Integer getTypedDateMes (){

        return Integer.parseInt(jtfMes.getText());

    }

    public Integer getTypedDateDia (){

        return Integer.parseInt(jtfDia.getText());

    }

    public Time getHora (){
        String time = jcbHores.getSelectedItem().toString();

        String[] parts = time.split(":");
        String horaString = parts[0]; // hores
        String minutString = parts[1]; // minuts

        int hora = Integer.parseInt(horaString);

        int minuts = Integer.parseInt(minutString);

        int segons = 0;

        return new Time(hora,minuts,segons) ;
    }

    public Integer getComensals(){
        return Integer.parseInt(jcbComensals.getSelectedItem().toString());
    }
}
