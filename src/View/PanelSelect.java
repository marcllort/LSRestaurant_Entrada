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

    public PanelSelect() {
        this.setSize(600, 400);
        this.setTitle("DPO-1718-LSRestaurant-Entrada");
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.entradaVista = new EntradaVista();


        this.reservarVista = new VistaReservar();


        this.demanarVista = new VistaDemanar();


        layout = new CardLayout();

        cards = new JPanel(layout);
        cards.add("ENTRADA", entradaVista);
        cards.add("RESERVAR", reservarVista);
        cards.add("DEMANAR", demanarVista);

        getContentPane().add(cards);

        setVisible(true);

    }

    public void changePanel(String quin){
        layout.show(cards, quin);
    }

    public void registraControlador(Controlador controlador) {
        entradaVista.registraControlador(controlador);
        reservarVista.registraControlador(controlador);
        demanarVista.registraControlador(controlador);
    }

    public EntradaVista getEntradaVista(){
        return entradaVista;
    }

    public VistaReservar getReservarVista() {
        return reservarVista;
    }

    public VistaDemanar getDemanarVista() {
        return demanarVista;
    }

    public void optionPaneResposta(String s) {

    }

    public void mostraMissatge(String s) {
        JFrame frame = new JFrame();

        JOptionPane.showMessageDialog(frame, s);

        frame.setVisible(true);
    }

    public void mostraError(int error) {
        //Mostrem JDialog
        String quinError;

        JFrame frame = new JFrame();

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
            JOptionPane.showMessageDialog(frame,
                    quinError,
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(frame,
                    quinError,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        frame.setVisible(true);
    }
}
