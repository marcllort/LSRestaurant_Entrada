package NetworkManager;

import Model.Json.ConfiguracioClient;
import Model.Json.LectorJson;
import Model.Reserva;
import View.PanelSelect;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ServerConnect {

    private static int portEntrada;
    private static String ipEntrada = "localhost";
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private DataInputStream dis;
    private String resposta;
    private LectorJson lectorJSON;
    private PanelSelect vista;

    /**
     * Constructor sense paràmetres per crear una nova connexio al server a partir de les dades del JSON
     */

    public ServerConnect(PanelSelect vista) {

        try {
            lectorJSON = new LectorJson();
            ConfiguracioClient config = lectorJSON.llegeixConfiguracioClient();
            portEntrada = config.lectorPortServer();
            ipEntrada = config.lectorIpServer();

            Socket socket = new Socket(ipEntrada, portEntrada);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            dis = new DataInputStream(socket.getInputStream());
            this.vista = vista;
        } catch (IOException e) {
            vista.mostraMissatge("No s'ha pogut connectar amb el servidor!");
            System.exit(0);
        }

    }

    /**
     * Envia les dades a la reserva
     *
     * @param reserva classe reserva que registra totes les dades
     */

    public void enviaReserva(Reserva reserva) {
        try {
            oos.writeObject(reserva);
        } catch (IOException e) {
            vista.mostraMissatge("El servidor s'ha desconectat!");
            System.exit(0);
        }
    }

    /**
     * Rep respostes del servidor
     *
     * @return resposta
     */

    public String repResposta() {
        try {
            resposta = dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resposta;
    }

}
