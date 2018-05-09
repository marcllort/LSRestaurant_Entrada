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
    private JSpinner jsComensals = new JSpinner();
    private JButton jbReservar = new JButton();
    private JButton jbHome = new JButton();
    private JPanel panel = new JPanel();

    /**
     * Constructor creador de la vista reservar, que reserva una taula amb la data i hora desitjats
     */

    public VistaReservar () {

        this.setLayout(null);

        JLabel lblLsrestaurant = new JLabel("LS RESTAURANT");
        lblLsrestaurant.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblLsrestaurant.setBounds(154, 16, 249, 34);
        this.add(lblLsrestaurant);

        jbReservar.setText("RESERVA");
        jbReservar.setFont(new Font("Tahoma", Font.BOLD, 20));
        jbReservar.setBounds(280, 195, 201, 34);
        this.add(jbReservar);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(38, 61, 502, 41);
        this.add(panel_1);

        JLabel lblUsuari = new JLabel("Usuari:");
        lblUsuari.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_1.add(lblUsuari);

        jtfUsuari.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_1.add(jtfUsuari);
        jtfUsuari.setColumns(24);

        panel.setBounds(38, 135, 383, 41);
        this.add(panel);

        JLabel lblDia = new JLabel("Dia: (dd/mm/aaaa)");
        lblDia.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(lblDia);

        jtfDia.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(jtfDia);
        jtfDia.setColumns(2);

        JLabel label = new JLabel("/");
        panel.add(label);

        jtfMes.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(jtfMes);
        jtfMes.setColumns(2);

        JLabel label_1 = new JLabel("/");
        panel.add(label_1);

        jtfAny.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(jtfAny);
        jtfAny.setColumns(4);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(426, 100, 115, 70);
        this.add(panel_2);

        JLabel lblHora = new JLabel("Hora:");
        lblHora.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_2.add(lblHora);

        jcbHores.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jcbHores.addItem("13:00");
        jcbHores.addItem("14:30");
        jcbHores.addItem("19:30");
        jcbHores.addItem("21:30");
        panel_2.add(jcbHores);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(38, 188, 186, 41);
        this.add(panel_3);

        JLabel lblComensals = new JLabel("Comensals:");
        lblComensals.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_3.add(lblComensals);

        jsComensals = new JSpinner();
        jsComensals.setModel(new SpinnerNumberModel(1,1,20,1));
        jsComensals.setBounds(123,5,52,32);
        jsComensals.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_3.add(jsComensals);


        jbHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jbHome.setBounds(10,11,55,35);
        this.add(jbHome);

    }

    /**
     * Getter del panell Reservar
     * @return vistaReservar
     */

    public JPanel getPanel (){
        return this;
    }

    /**
     * Registra tots els botons amb el controlador per tal que l'ActionListener els detecti
     * @param controller    controlador que requereix
     */

    public void registraControlador(ActionListener controller) {

        jbReservar.addActionListener(controller);
        jbReservar.setActionCommand("NovaReserva");
        jbHome.addActionListener(controller);
        jbHome.setActionCommand("Home");

    }

    /**
     * Getter del contingut del JTextField de l'usuari
     * @return usuari
     */

    public String getTypedUser (){
        return jtfUsuari.getText();
    }

    /**
     * Getter del contingut del JTextField de l'any
     * @return any
     */


    public Integer getTypedDateAny (){

        try{

            return Integer.parseInt(jtfAny.getText());

        }catch (Exception e){

            jtfAny.setText("");

            return 420;

        }

    }

    /**
     * Getter del contingut del JTextField del mes
     * @return mes
     */

    public Integer getTypedDateMes (){

        try {

            return Integer.parseInt(jtfMes.getText());

        }catch (Exception e){

            jtfMes.setText("");

            return 420;
        }

    }

    /**
     * Getter del contingut del JTextField del dia
     * @return dia
     */

    public Integer getTypedDateDia (){

        try {

            return Integer.parseInt(jtfDia.getText());

        }catch (Exception e){
            jtfDia.setText("");

            return 420;
        }

    }

    /**
     * Getter de la hora seleccionada
     * @return hora
     */

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

    /**
     * Getter de la quantitat de comensals que hi haura
     * @return nComensals
     */

    public Integer getComensals(){
        return Integer.parseInt(jsComensals.getValue().toString());
    }

    /**
     * Reseteja les dades del panell per si es vol fer una nova reserva
     */

    public void netejaDades() {

        jtfUsuari.setText("");
        jtfAny.setText("");
        jtfMes.setText("");
        jtfDia.setText("");
        jsComensals.setValue(1);
        jcbHores.setSelectedIndex(0);

    }
}
