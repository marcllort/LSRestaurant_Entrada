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
}
