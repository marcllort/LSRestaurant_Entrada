package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class VistaDemanar extends JPanel{

    private static final int MAX_COMENSALS = 15;
    private JTextField jtfUsuari = new JTextField();
    private JComboBox<String> jcbComensals = new JComboBox<>();
    private JButton jbDemanar = new JButton();
    private JButton jbHome = new JButton();

    public VistaDemanar () {

        JPanel jpMain = demanar();       //Creem el JPanel principal

        this.add(jpMain);

    }

    private JPanel demanar() {

        JPanel jpReserva = new JPanel();

        jpReserva.setLayout(new BoxLayout(jpReserva, BoxLayout.PAGE_AXIS));

        JLabel jlTitol = new JLabel("LS RESTAURANT");

        jpReserva.add(jlTitol);
        jpReserva.add(usuari());
        jpReserva.add(comensals());
        jbDemanar.setText("Demanar");
        jpReserva.add(jbDemanar);
        jbHome.setText("Home");
        jpReserva.add(jbHome);

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

    private JPanel usuari() {
        JPanel jpUsu = new JPanel();

        jpUsu.setLayout(new GridLayout(1,2));

        jpUsu.add(new JLabel("Usuari: "));

        jpUsu.add(jtfUsuari);

        return jpUsu;
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
        return Integer.parseInt(jcbComensals.getSelectedItem().toString());
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
        jcbComensals.setSelectedIndex(0);

    }
}
