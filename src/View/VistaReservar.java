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
    private JButton jbHome = new JButton();
    private JPanel panel = new JPanel();


    public VistaReservar () {

        this.setLayout(null);

        JLabel lblLsrestaurant = new JLabel("LS_RESTAURANT");
        lblLsrestaurant.setBounds(174, 11, 86, 14);
        this.add(lblLsrestaurant);

        jbReservar.setText("RESERVA");
        jbReservar.setBounds(171, 158, 89, 23);
        this.add(jbReservar);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(15, 36, 391, 30);
        this.add(panel_1);

        JLabel lblUsuari = new JLabel("Usuari:");
        panel_1.add(lblUsuari);

        jtfUsuari = new JTextField();
        panel_1.add(jtfUsuari);
        jtfUsuari.setColumns(42);

        panel.setBounds(15, 77, 391, 30);
        this.add(panel);

        JLabel lblDia = new JLabel("Dia: (dd/mm/aaaa)");
        panel.add(lblDia);

        jtfDia = new JTextField();
        panel.add(jtfDia);
        jtfDia.setColumns(10);

        JLabel label = new JLabel("/");
        panel.add(label);

        jtfMes = new JTextField();
        panel.add(jtfMes);
        jtfMes.setColumns(10);

        JLabel label_1 = new JLabel("/");
        panel.add(label_1);

        jtfAny = new JTextField();
        panel.add(jtfAny);
        jtfAny.setColumns(10);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(15, 118, 269, 29);
        this.add(panel_2);

        JLabel lblHora = new JLabel("Hora:");
        panel_2.add(lblHora);

        jcbHores.addItem("13:00");
        jcbHores.addItem("14:30");
        jcbHores.addItem("19:30");
        jcbHores.addItem("21:30");

        panel_2.add(jcbHores);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(306, 118, 100, 30);
        this.add(panel_3);

        JLabel lblComensals = new JLabel("Comensals:");
        panel_3.add(lblComensals);

        JSpinner spinner = new JSpinner();
        panel_3.add(spinner);

    }

    private JPanel Reserva() {



        return panel;
    }

    public JPanel getPanel (){
        return this;
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
        jbHome.addActionListener(controller);
        jbHome.setActionCommand("Home");

    }

    public String getTypedUser (){
        return jtfUsuari.getText();
    }

    public Integer getTypedDateAny (){

        try{

            return Integer.parseInt(jtfAny.getText());

        }catch (Exception e){

            jtfAny.setText("");

            return 420;

        }

    }

    public Integer getTypedDateMes (){

        try {

            return Integer.parseInt(jtfMes.getText());

        }catch (Exception e){

            jtfMes.setText("");

            return 420;
        }

    }

    public Integer getTypedDateDia (){

        try {

            return Integer.parseInt(jtfDia.getText());

        }catch (Exception e){
            jtfDia.setText("");

            return 420;
        }

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

    public void netejaDades() {

        jtfUsuari.setText("");
        jtfAny.setText("");
        jtfMes.setText("");
        jtfDia.setText("");
        jcbComensals.setSelectedIndex(0);
        jcbHores.setSelectedIndex(0);

    }
}
