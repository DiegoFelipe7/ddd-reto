package co.com.sofka.pasajero.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Identificacion;
/**
 * DomainEvent IdentificacionActualizada
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
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
