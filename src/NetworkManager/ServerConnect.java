package NetworkManager;

import Model.Json.ConfiguracioClient;
import Model.Json.LectorJson;
import Model.Reserva;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ServerConnect {

    public static int portEntrada;
    private static String ipEntrada = "localhost";
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private DataInputStream dis;
    private String resposta;
    private LectorJson lectorJSON;

    /**
     * Constructor sense paràmetres per crear una nova connexio al server a partir de les dades del JSON
     */

    public ServerConnect() {

        try {
            lectorJSON = new LectorJson();
            ConfiguracioClient config = lectorJSON.llegeixConfiguracioClient();
            portEntrada = config.lectorPortServer();
            ipEntrada = config.lectorIpServer();

            Socket socket = new Socket(ipEntrada, portEntrada);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Envia les dades a la reserva
     * @param reserva
     */

    public void enviaReserva(Reserva reserva) {
        try {
            oos.writeObject(reserva);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Rep respostes del servidor
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
