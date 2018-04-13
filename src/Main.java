import Controller.Controlador;
import NetworkManager.ServerConnect;
import View.PanelSelect;


public class Main {

    public static void main(String[] args) {
        PanelSelect ps = new PanelSelect();

        ServerConnect serverConnect = new ServerConnect();

        Controlador controlador = new Controlador(ps, serverConnect);

        ps.registraControlador(controlador);
        
        ps.setVisible(true);

    }
}
