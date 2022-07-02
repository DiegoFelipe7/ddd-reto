package co.com.sofka.bus.events;

import co.com.sofka.bus.values.Placa;
import co.com.sofka.domain.generic.DomainEvent;
/**
 * DomainEvent PlacaActualizada
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
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
