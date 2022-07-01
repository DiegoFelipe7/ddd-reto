package co.com.sofka.pasajero;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.pasajero.entitys.Equipaje;
import co.com.sofka.pasajero.entitys.Ticket;
import co.com.sofka.pasajero.events.EquipajeRegistrado;
import co.com.sofka.pasajero.events.PasajeroCreado;
import co.com.sofka.pasajero.events.TicketComprado;

import java.util.HashSet;

public class PasajeroEventChangue extends EventChange {
    public PasajeroEventChangue(Pasajero pasajero){
        apply((PasajeroCreado event)->{
            pasajero.nombre=event.getNombre();
            pasajero.identificacion=event.getIdentificacion();
            pasajero.ticket=new HashSet<>();
            pasajero.equipaje= new HashSet<>();
            pasajero.asiento= event.getAsiento();

        });

        apply((TicketComprado event)->{
            pasajero.ticket.add(new Ticket(event.getIdTicket(),event.getPrecio(),event.getDestino() , event.getFecha() , event.getEstado()));
        });

        apply((EquipajeRegistrado event)->{
            pasajero.equipaje.add(new Equipaje(event.getIdEquipaje(),event.getPeso(),event.getDescripcion()));
        });


    }
}
