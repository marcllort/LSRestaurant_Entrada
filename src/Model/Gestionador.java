package Model;

import java.sql.Date;
//import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

/**
 * Classe que gestiona totes les dates de la reserva
 */

public class Gestionador {


    /**
     * Comprovador per saber si la data és correcte
     *
     * @param input
     * @return laDataEsCorrecte
     */

    public synchronized boolean isValidDate(String input) {                                          //COPMPROVAR SI LA DATA ES CORRECTA
        String formatString = "yyyy-MM-dd";

        try {
            SimpleDateFormat data = new SimpleDateFormat(formatString);
            data.setLenient(false);
            data.parse(input);
        } catch (ParseException | IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    /**
     * Genera una nova data a partir dels 3 paràmetres
     *
     * @param any
     * @param mes
     * @param dia
     * @return data
     */

    public synchronized java.sql.Date newData(Integer dia, Integer mes, Integer any) {
        if (isValidDate(any + "-" + mes + "-" + dia)) {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, any);
            cal.set(Calendar.MONTH, mes - 1);
            cal.set(Calendar.DAY_OF_MONTH, dia);

            java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());
            java.util.Date dataNow = new java.util.Date();
            if (data.before(dataNow)){
                return null;
            }
            return new java.sql.Date(cal.getTimeInMillis());
        }
        return null;
    }


}
