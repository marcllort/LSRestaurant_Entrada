package Model.Json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

/**
 * Classe que utilitzem per llegir les dades del JSON
 */

public class LectorJson {

    private String FILE_NAME ;

    /**
     * Constructor del lector del JSON que estableix la ruta
     */

    public LectorJson (){
    FILE_NAME = System.getProperty("user.dir") + "/data/config.json"; //Nom de l'arxiu a obrir
    }

    /**
     * Llegeix el fitxer i ho passa tot a la classe ConfiguracioClient
     * @return configuracio del client
     */

    public ConfiguracioClient llegeixConfiguracioClient() {             //Els args son useless
        ConfiguracioClient data ;          // Dades a carregar
        Gson        gson = new Gson();                   // Entitat Gson
        JsonReader  reader;                              // Reader de JSON

        try {               //Intentem carregar el fitxer json

            reader = new JsonReader(new FileReader(FILE_NAME));
            data = gson.fromJson(reader, ConfiguracioClient.class);

            return data;

        } catch (FileNotFoundException e) {
            System.err.println("No s'ha pogut trobar el fitxer.");
            return null;
        }
    }

}
