package co.com.sofka.bus.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.pasajero.values.IdPasajero;
/**
 * DomainEvent PasajeroAgregado
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
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
