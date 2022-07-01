package co.com.sofka.pasajero.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.entitys.Asiento;

public class PasajeroCreado extends DomainEvent {
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Asiento asiento;

    public PasajeroCreado(Nombre nombre, Identificacion identificacion, Asiento asiento) {
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

    public Asiento getAsiento() {
        return asiento;
    }
}
