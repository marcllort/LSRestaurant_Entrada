package Model.Json;

/**
 * Classe que emmagatzema els valors del JSON
 */

public class ConfiguracioClient {

    private int portServer;            //  Port de connexio amb el servidor

    private String ipServer;        // IP del servidor


    /**
     * Getter Port del server
     * @return port
     */

    public int lectorPortServer() {
        return portServer;
    }

    /**
     * Getter IP del server
     * @return ip
     */

    public String lectorIpServer() {
        return ipServer;
    }

}
