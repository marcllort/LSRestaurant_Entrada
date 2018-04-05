import View.EntradaVista;
import View.VistaReservar;

public class Main {

    public static void main(String[] args) {
        EntradaVista e_vista = new EntradaVista();          //Inicialitzem la vista
        VistaReservar r_vista = new VistaReservar();

        r_vista.setVisible(true);
        e_vista.setVisible(true);                           //Fem que sigui visible
        
    }


}
