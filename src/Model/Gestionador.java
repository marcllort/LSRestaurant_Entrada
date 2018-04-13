package Model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Gestionador {


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

    public synchronized Date newData(Integer dia, Integer mes, Integer any) {
        if (isValidDate(any + "-" + mes + "-" + dia)) {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, any);
            cal.set(Calendar.MONTH, mes - 1);
            cal.set(Calendar.DAY_OF_MONTH, dia);


            return new Date(cal.getTimeInMillis());
        }
        return null;
    }


}
