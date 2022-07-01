package co.com.sofka.bus.events;

import co.com.sofka.bus.values.Placa;
import co.com.sofka.domain.generic.DomainEvent;

public class PlacaActualizada extends DomainEvent {
    private final Placa placa;
    public PlacaActualizada(Placa placa) {
        super("sofka.bus.event.PlacaActualizada");
        this.placa=placa;
    }

    public Placa getPlaca() {
        return placa;
    }
}
