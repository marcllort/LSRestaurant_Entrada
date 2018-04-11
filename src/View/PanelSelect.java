package View;

import Controller.Controlador;

import javax.swing.*;
import java.awt.*;

public class PanelSelect extends JFrame{

    private EntradaVista entradaVista;
    private VistaReservar reservarVista;
    private VistaDemanar demanarVista;
    private Controlador controlador;
    private Controlador controlador_ev;
    private Controlador controlador_vr;
    private Controlador controlador_vd;
    private CardLayout layout;
    private JPanel cards;

    public PanelSelect() {
        this.setSize(600, 400);
        this.setTitle("DPO-1718-LSRestaurant-Entrada");
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.entradaVista = new EntradaVista();
        controlador_ev = new Controlador(entradaVista);
        entradaVista.registraControlador(controlador_ev);

        this.reservarVista = new VistaReservar();
        controlador_vr = new Controlador(reservarVista);
        reservarVista.registraControlador(controlador_vr);

        this.demanarVista = new VistaDemanar();
        controlador_vd = new Controlador(reservarVista);
        demanarVista.registraControlador(controlador_vd);

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
        this.controlador = controlador;
    }
}
