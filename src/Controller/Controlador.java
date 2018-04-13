package Controller;

import Model.Gestionador;
import Model.Reserva;
import NetworkManager.ServerConnect;
import View.PanelSelect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class Controlador implements ActionListener {

    private PanelSelect ps;
    private Gestionador gestionador;
    private ServerConnect sc;

    public Controlador (PanelSelect ps, ServerConnect sc){
        this.ps = ps;
        this.sc = sc;
        this.gestionador = new Gestionador();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Home")){
            ps.changePanel("ENTRADA");
        }

        if (e.getActionCommand().equals("DEMANAR")){
            System.out.println("Demanar");
            ps.changePanel("DEMANAR");
        }

        if (e.getActionCommand().equals("RESERVAR")){
            System.out.println("Reservar");
            ps.changePanel("RESERVAR");
        }

        if (e.getActionCommand().equals("NovaReserva")){
            System.out.println("Nova Reserva Sol·licitada");

            //Reserva de prova, enviar la real entrada per l'usuari
            Reserva reserva = new Reserva(
                    ps.getReservarVista().getTypedUser(),
                    ps.getReservarVista().getComensals(),
                    gestionador.newData(ps.getReservarVista().getTypedDateDia(),
                            ps.getReservarVista().getTypedDateMes(),
                            ps.getReservarVista().getTypedDateAny()),
                    ps.getReservarVista().getHora());

            System.out.println(reserva.toString());

            int error = isValidaDades(reserva);

            if(error == 0){
                ps.getReservarVista().netejaDades();

                //Enviar quan toquin el boto
                sc.enviaReserva(reserva);

                //Just després rebem la contranseya o el error en un string, mostrar per jdialog
                ps.mostraMissatge(sc.repResposta());

                ps.changePanel("ENTRADA");
            }else{
                //Missatge d'error
                ps.mostraError(error);
            }

        }

        if (e.getActionCommand().equals("NovaDemanda")){
            System.out.println("Nova Demanda Sol·licitada");

            //Reserva de prova, enviar la real entrada per l'usuari
            Reserva reserva = new Reserva(
                    ps.getDemanarVista().getTypedUser(),
                    ps.getDemanarVista().getComensals(),
                    gestionador.newData(
                            ps.getDemanarVista().getTypedDateDia(),
                            ps.getDemanarVista().getTypedDateMes(),
                            ps.getDemanarVista().getTypedDateAny()),
                    ps.getDemanarVista().nextHour());

            System.out.println(reserva.toString());

            int error = isValidaDades(reserva);

            if(error == 0){
                ps.getDemanarVista().netejaDades();

                //Enviar quan toquin el boto
                sc.enviaReserva(reserva);

                //Just després rebem la contranseya o el error en un string, mostrar per jdialog
                ps.mostraMissatge(sc.repResposta());

                ps.changePanel("ENTRADA");
            }else{
                //Missatge d'error
                ps.mostraError(error);
            }

        }
    }

    private int isValidaDades(Reserva reserva) {
        if (reserva.getUsuari().equals("")){
            return 1;
        }else{
            if(reserva.getData() == null){
                return 2;
            }else{
                if (reserva.getHora().getHours() == 25){
                    return 3;
                }
                if (LocalTime.now().getHour() > reserva.getHora().getHours()){
                    return 3;
                }
                if (LocalTime.now().getHour() == reserva.getHora().getHours() && LocalTime.now().getMinute() > reserva.getHora().getMinutes()){
                    return 3;
                }

            }
        }
        return 0;
    }
}
