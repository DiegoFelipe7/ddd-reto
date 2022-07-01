package co.com.sofka.bus.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.pasajero.values.IdPasajero;

public class PasajerosAgregados extends DomainEvent {
    private final IdPasajero idPasajero;

    public PasajerosAgregados( IdPasajero idPasajero) {
        super("sofka.bus.event.PasajerosAgregados");
        this.idPasajero = idPasajero;
    }

    public IdPasajero getIdPasajero() {
        return idPasajero;
    }
}
