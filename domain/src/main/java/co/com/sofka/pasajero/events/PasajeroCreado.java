package co.com.sofka.pasajero.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalues.Identificacion;
import co.com.sofka.genericvalues.Nombre;
import co.com.sofka.pasajero.entitys.Asiento;
import co.com.sofka.pasajero.values.IdAsiento;

import java.util.Set;

public class PasajeroCreado extends DomainEvent {
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final IdAsiento asiento;

    public PasajeroCreado(Nombre nombre, Identificacion identificacion, IdAsiento asiento) {
        super("sofka.pasajero.event.PasajeroCreado");
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.asiento = asiento;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public IdAsiento getAsiento() {
        return asiento;
    }
}
