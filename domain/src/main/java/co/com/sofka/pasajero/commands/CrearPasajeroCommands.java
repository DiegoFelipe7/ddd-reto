package co.com.sofka.pasajero.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.entitys.Asiento;
import co.com.sofka.pasajero.entitys.Equipaje;
import co.com.sofka.pasajero.entitys.Ticket;
import co.com.sofka.pasajero.values.IdPasajero;

import java.util.Set;

public class CrearPasajeroCommands extends Command {
    private final IdPasajero idPasajero;
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Set<Ticket> ticket;
    private final Set<Equipaje> equipaje;
    private final Asiento asiento;

    public CrearPasajeroCommands(IdPasajero idPasajero, Nombre nombre, Identificacion identificacion, Set<Ticket> ticket, Set<Equipaje> equipaje, Asiento asiento) {
        this.idPasajero = idPasajero;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.ticket = ticket;
        this.equipaje = equipaje;
        this.asiento = asiento;
    }

    public IdPasajero getIdPasajero() {
        return idPasajero;
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
