package Controller;

import Model.PanelSelect;
import View.EntradaVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    private final EntradaVista vista;

    private PanelSelect panelSelect = new PanelSelect();

    public Controlador (EntradaVista vista){
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton)e.getSource()).getText().equals("RESERVAR")){
            panelSelect.changePanel("RESERVAR");
        }
        if (((JButton)e.getSource()).getText().equals("DEMANAR")){
            panelSelect.changePanel("DEMANAR");
        }
    }
}
