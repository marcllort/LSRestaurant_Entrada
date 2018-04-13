import Controller.Controlador;
import View.PanelSelect;

public class Main {

    public static void main(String[] args) {
        PanelSelect ps = new PanelSelect();

        Controlador controlador = new Controlador(ps);

        ps.registraControlador(controlador);
        
        ps.setVisible(true);
    }
}
