package View;

import Controller.Controlador;

import javax.swing.*;
import java.awt.*;

public class PanelSelect extends JFrame{

    private EntradaVista entradaVista;
    private VistaReservar reservarVista;
    private VistaDemanar demanarVista;
    private CardLayout layout;
    private JPanel cards;

    /**
     * Constructor que crea el Card Layout que intercanviara les 3 vistes del programa
     */

    public PanelSelect() {
        this.setSize(600, 330);
        this.setTitle("DPO-1718-LSRestaurant-Entrada");
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.entradaVista = new EntradaVista();


        this.reservarVista = new VistaReservar();


        this.demanarVista = new VistaDemanar();


        layout = new CardLayout();

        cards = new JPanel(layout);
        cards.add("ENTRADA", entradaVista.getPanel());
        cards.add("RESERVAR", reservarVista.getPanel());
        cards.add("DEMANAR", demanarVista);

        getContentPane().add(cards);

        setVisible(true);

    }

    /**
     * Canvia el panell actual a un altre
     * @param quin
     */

    public void changePanel(String quin){
        layout.show(cards, quin);
    }

    /**
     * Registra tots els botons amb el controlador per tal que l'ActionListener els detecti
     * @param controlador
     */

    public void registraControlador(Controlador controlador) {
        entradaVista.registraControlador(controlador);
        reservarVista.registraControlador(controlador);
        demanarVista.registraControlador(controlador);
    }

    /**
     * Getter de la vista d'entrada
     * @return Vista Entrada
     */

    public EntradaVista getEntradaVista(){
        return entradaVista;
    }

    /**
     * Getter de la vista reserva
     * @return Vista Reserva
     */

    public VistaReservar getReservarVista() {
        return reservarVista;
    }

    /**
     * Getter de la vista demanar
     * @return Vista Demanar
     */

    public VistaDemanar getDemanarVista() {
        return demanarVista;
    }

    /**
     * Mostra un missatge (rebut per parametre) a través d'un JOptionPane
     * @param s
     */

    public void mostraMissatge(String s) {

        JOptionPane.showMessageDialog(this, s);

        this.setVisible(true);
    }

    /**
     * Mostra un dels errors (rebut per parametre) a través d'un JOptionPane
     * @param error
     */

    public void mostraError(int error) {
        String quinError;



        switch (error){
            case 1:
                quinError = "No has introduit usuari!";
                break;
            case 2:
                quinError = "Error detectat en la data!";
                break;
            case 3:
                quinError = "Error detectat en la hora!";
                break;
            default:
                quinError = "Error indefinit";
                break;
        }

        if (error == 1){
            JOptionPane.showMessageDialog(this,
                    quinError,
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(this,
                    quinError,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        this.setVisible(true);
    }
}
