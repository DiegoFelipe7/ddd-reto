package co.com.sofka.pasajero;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.pasajero.values.IdPasajero;

public class Pasajero extends AggregateEvent<IdPasajero>{
    public Pasajero(IdPasajero entityId) {
        super(entityId);
    }
}
