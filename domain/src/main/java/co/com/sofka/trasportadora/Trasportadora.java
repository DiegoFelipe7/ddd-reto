package co.com.sofka.trasportadora;

import co.com.sofka.bus.Bus;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.trasportadora.entitys.Cedes;
import co.com.sofka.trasportadora.entitys.Nomina;
import co.com.sofka.trasportadora.values.IdTrasportadora;
import co.com.sofka.trasportadora.values.Nit;

import java.util.Set;

public class Trasportadora extends AggregateEvent<IdTrasportadora> {
    protected Nit nit;
    protected Nombre nombre;
    protected Set<Bus> busSet;
    protected Nomina nomina;
    protected Set<Cedes> cedesSet;
    public Trasportadora(IdTrasportadora entityId) {
        super(entityId);
    }




}
