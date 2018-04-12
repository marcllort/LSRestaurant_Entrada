package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

public class VistaDemanar extends JPanel{

    private static final int MAX_COMENSALS = 15;
    private JTextField jtfUsuari = new JTextField();
    private JComboBox<String> jcbComensals = new JComboBox<>();
    private JButton jbDemanar = new JButton();

    public VistaDemanar () {

        JPanel jpMain = Reserva();       //Creem el JPanel principal

        this.add(jpMain);

    }

    private JPanel Reserva() {

        JPanel jpReserva = new JPanel();

        jpReserva.setLayout(new BoxLayout(jpReserva, BoxLayout.PAGE_AXIS));

        JLabel jlTitol = new JLabel("LS RESTAURANT");

        jpReserva.add(jlTitol);
        jpReserva.add(usuari());
        jpReserva.add(comensals());
        jbDemanar.setText("Demanar");
        jpReserva.add(jbDemanar);

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

    }

    public String getTypedUser (){
        return jtfUsuari.getText();
    }

    public String getPCdate(){
        return LocalDate.now().toString();
    }

    public String getPChour(){
        return LocalTime.now().toString();
    }

    public String getComensals(){
        return (String) jcbComensals.getSelectedItem();
    }


}
