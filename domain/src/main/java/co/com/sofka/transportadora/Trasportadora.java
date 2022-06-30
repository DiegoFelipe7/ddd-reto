package co.com.sofka.transportadora;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.transportadora.values.IdTrasportadora;

public class Trasportadora extends AggregateEvent<IdTrasportadora> {

    public Trasportadora(IdTrasportadora entityId) {
        super(entityId);
    }
}
