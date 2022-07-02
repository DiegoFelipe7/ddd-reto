package co.com.sofka.trasportadora.events;

import co.com.sofka.bus.values.IdBus;
import co.com.sofka.domain.generic.DomainEvent;
/**
 * DomainEvent BusContratado
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class BusContratado extends DomainEvent {
    private IdBus idBus;

    public BusContratado(IdBus idBus) {
        super("sofka.trasportadora.event.BusContratado");
        this.idBus = idBus;
    }

    public IdBus getIdBus() {
        return idBus;
    }
}
