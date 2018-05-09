package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class VistaDemanar extends JPanel{

    private static final int MAX_COMENSALS = 20;
    private JTextField jtfUsuari = new JTextField();
    private JSpinner jsComensals = new JSpinner();
    private JButton jbDemanar = new JButton();
    private JButton jbHome = new JButton();
    private JPanel panel = new JPanel();

    /**
     * Constructor creador de la vista demanar, que reserva una taula amb la data i hora actuals
     */

    public VistaDemanar () {

        //Demanar

        this.setLayout(null);

        JLabel label = new JLabel("LS RESTAURANT");
        label.setFont(new Font("Tahoma", Font.BOLD, 28));
        label.setBounds(155, 29, 261, 39);
        this.add(label);

        jbDemanar.setText("DEMANAR");
        jbDemanar.setFont(new Font("Tahoma", Font.BOLD, 20));
        jbDemanar.setBounds(204, 210, 141, 39);
        this.add(jbDemanar);

        panel.setBounds(46, 101, 475, 39);
        this.add(panel);

        JLabel label_1 = new JLabel("Usuari:");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_1);

        jtfUsuari.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jtfUsuari.setColumns(23);
        panel.add(jtfUsuari);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(46, 151, 175, 42);
        this.add(panel_3);

        JLabel label_6 = new JLabel("Comensals:");
        label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_3.add(label_6);

        jsComensals.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jsComensals.setModel(new SpinnerNumberModel(1,1,20,1));
        panel_3.add(jsComensals);


        jbHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jbHome.setBounds(10,11,55,35);
        this.add(jbHome);
    }

    /**
     * Getter del panell Demanar
     * @return vistaDemanar
     */

    public JPanel getPanel (){
        return this;
    }

    /**
     * Registra tots els botons amb el controlador per tal que l'ActionListener els detecti
     * @param controller    controlador que requereix
     */

    public void registraControlador(ActionListener controller) {

        jbDemanar.addActionListener(controller);
        jbDemanar.setActionCommand("NovaDemanda");
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
     * Calcula quina és la hora més pròxima per reservar
     * @return hora
     */

    public Time nextHour(){
        int hores = LocalTime.now().getHour();

        boolean isDone = false;

        if (hores < 13){
            isDone = true;
        }

        while (hores != 13 && hores != 14 && hores != 19 && hores != 21 && hores != 25){
            hores++;
        }

        if(LocalTime.now().getMinute() > 0 && hores == 13 && !isDone && hores != 25){
            hores++;
            while (hores != 13 && hores != 14 && hores != 19 && hores != 21 && hores != 25){
                hores++;
            }
            isDone = true;
        }

        if (LocalTime.now().getMinute() > 30 && hores != 13 && !isDone && hores != 25){
            hores++;
            while (hores != 13 && hores != 14 && hores != 19 && hores != 21 && hores != 25){
                hores++;
            }
            isDone = true;
        }

        int minuts;

        if(hores == 13 || hores == 25){
           minuts = 0;
        }else{
           minuts = 30;
        }

        Time hora = new Time (hores,minuts,0);

        return hora;
    }

    /**
     * Getter de la quantitat de comensals
     * @return nComensals
     */

    public Integer getComensals(){
        return Integer.parseInt(jsComensals.getValue().toString());
    }

    /**
     * Getter del dia en el que estem
     * @return dia
     */

    public Integer getTypedDateDia() {
        return LocalDate.now().getDayOfMonth();
    }

    /**
     * Getter del mes en el que estem
     * @return mes
     */

    public Integer getTypedDateMes() {
        return LocalDate.now().getMonthValue();
    }

    /**
     * Getter de l'any en el que estem
     * @return any
     */

    public Integer getTypedDateAny() {
        return LocalDate.now().getYear();
    }

    /**
     * Reseteja les dades del panell per si es vol fer una nova reserva
     */

    public void netejaDades() {

        jtfUsuari.setText("");
        jsComensals.setValue(1);

    }
}
