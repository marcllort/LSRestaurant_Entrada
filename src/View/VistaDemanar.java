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

        jbHome.setText("←");
        jbHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jbHome.setBounds(10,11,55,35);
        this.add(jbHome);
    }

    public JPanel getPanel (){
        return this;
    }


    public void registraControlador(ActionListener controller) {

        jbDemanar.addActionListener(controller);
        jbDemanar.setActionCommand("NovaDemanda");
        jbHome.addActionListener(controller);
        jbHome.setActionCommand("Home");

    }

    public String getTypedUser (){
        return jtfUsuari.getText();
    }

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

    public Integer getComensals(){
        return Integer.parseInt(jsComensals.getValue().toString());
    }


    public Integer getTypedDateDia() {
        return LocalDate.now().getDayOfMonth();
    }

    public Integer getTypedDateMes() {
        return LocalDate.now().getMonthValue();
    }

    public Integer getTypedDateAny() {
        return LocalDate.now().getYear();
    }

    public void netejaDades() {

        jtfUsuari.setText("");
        jsComensals.setValue(0);

    }
}
