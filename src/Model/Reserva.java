package Model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * Classe que emmagatzema totes les dades de la reserva
 * Implementa Serializable per poder enviar-la al servidor
 */
public class Reserva implements Serializable {

    private String usuari;
    private Integer nComencals;
    private Date data;
    private Time hora;

    /**
     * Constructor amb tots els parametres per crear una nova reserva amb totes les dades
     *
     * @param nom
     * @param nComencals
     * @param data
     * @param hora
     */

    public Reserva(String nom, int nComencals, Date data, Time hora) {
        this.usuari = nom;
        this.nComencals = nComencals;
        this.data = data;
        this.hora = hora;
    }

    /**
     * Getter de l'usuari
     *
     * @return usuari
     */

    public String getUsuari() {
        return usuari;
    }

    /**
     * Getter dels comensals
     *
     * @return nComensals
     */

    public Integer getnComencals() {
        return nComencals;
    }

    /**
     * Getter de la data
     *
     * @return data
     */

    public Date getData() {
        return data;
    }

    /**
     * Getter de la hora
     *
     * @return hora
     */

    public Time getHora() {
        return hora;
    }

    /**
     * Retorna totes les dades en un string, per una millor lectura
     *
     * @return reservaString
     */

    @Override
    public String toString() {
        return usuari + " - " + nComencals + " - " + data + " - " + hora;
    }


}