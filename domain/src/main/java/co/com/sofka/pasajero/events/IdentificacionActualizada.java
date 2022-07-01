package co.com.sofka.pasajero.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Identificacion;

public class IdentificacionActualizada extends DomainEvent {
    private final Identificacion identificacion;

    public IdentificacionActualizada(Identificacion identificacion) {
        super("sofka.pasajero.event.IdentificacionActualizada");
        this.identificacion=identificacion;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }
}
