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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("DEMANAR")){
            System.out.println("Demanar");
            ps.changePanel("DEMANAR");
        }

        if (e.getActionCommand().equals("RESERVAR")){
            System.out.println("Reservar");
            ps.changePanel("RESERVAR");
        }

        if (e.getActionCommand().equals("NovaReserva")){
            System.out.println("Nova Reserva Sol·licitada");
            System.out.println("A nom de: " + ps.getReservarVista().getTypedUser() + "\nDia: " + ps.getReservarVista().getTypedDate().toString() + "\nHora: " + ps.getReservarVista().getHora() + "\nComensals: " + ps.getReservarVista().getComensals());
        }

        if (e.getActionCommand().equals("NovaDemanda")){
            System.out.println("Nova Demanda Sol·licitada");
            System.out.println("A nom de: " + ps.getDemanarVista().getTypedUser() + "\nDia: " + ps.getDemanarVista().getPCdate() + "\nHora: " + ps.getDemanarVista().getPChour() + "\nComensals: " + ps.getDemanarVista().getComensals());
        }
    }
}
