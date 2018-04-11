package Controller;

import View.PanelSelect;
import View.EntradaVista;
import View.VistaDemanar;
import View.VistaReservar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    private PanelSelect ps;
    private EntradaVista ev;
    private VistaReservar vr;
    private VistaDemanar vd;

    public Controlador (PanelSelect ps){
        this.ps = ps;
    }

    public Controlador (EntradaVista ev){
        this.ev = ev;
    }

    public Controlador (VistaReservar vr){
        this.vr = vr;
    }

    public Controlador (VistaDemanar vd){
        this.vd = vd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton)e.getSource()).getText().equals("DEMANAR")){
            System.out.println("Demanar");
            ps.changePanel("DEMANAR");
        }

        if (((JButton)e.getSource()).getText().equals("RESERVAR")){
            System.out.println("Reservar");
            ps.changePanel("RESERVAR");
        }
    }
}
