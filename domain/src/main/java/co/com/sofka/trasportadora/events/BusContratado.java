package co.com.sofka.trasportadora.events;

import co.com.sofka.bus.values.IdBus;
import co.com.sofka.domain.generic.DomainEvent;

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
