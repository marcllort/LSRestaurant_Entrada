package Model;

import Controller.Controlador;
import View.EntradaVista;
import View.VistaDemanar;
import View.VistaReservar;

import javax.swing.*;
import java.awt.*;

public class PanelSelect extends JFrame{

    JPanel cards;

    private EntradaVista entradaVista;
    private VistaReservar reservarVista;
    private VistaDemanar demanarVista;
    private Controlador controlador;
    private CardLayout layout;

    public PanelSelect() {
        this.entradaVista = new EntradaVista();
        this.reservarVista = new VistaReservar();
        this.demanarVista = new VistaDemanar();

        getContentPane().setLayout(layout);
        getContentPane().add("ENTRADA", entradaVista);

        this.setSize(600, 400);
        this.setTitle("DPO-1718-LSRestaurant-Entrada");
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        getContentPane().add("RESERVAR", reservarVista);
        getContentPane().add("DEMANAR", demanarVista);

    }

    public void changePanel(String quin){
        layout.show(this.getContentPane(), quin);
    }

}
