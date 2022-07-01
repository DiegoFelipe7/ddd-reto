package co.com.sofka.pasajero.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.entitys.Asiento;
import co.com.sofka.pasajero.entitys.Equipaje;
import co.com.sofka.pasajero.entitys.Ticket;

import java.util.Set;

public class PasajeroCreado extends DomainEvent {
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Set<Ticket> ticket;
    private final Set<Equipaje> equipaje;
    private final Asiento asiento;

    public PasajeroCreado(Nombre nombre, Identificacion identificacion, Set<Ticket> ticket, Set<Equipaje> equipaje, Asiento asiento) {
        super("sofka.pasajero.event.PasajeroCreado");
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.ticket = ticket;
        this.equipaje = equipaje;
        this.asiento = asiento;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public Set<Ticket> getTicket() {
        return ticket;
    }

    public Set<Equipaje> getEquipaje() {
        return equipaje;
    }

    public Asiento getAsiento() {
        return asiento;
    }
}
