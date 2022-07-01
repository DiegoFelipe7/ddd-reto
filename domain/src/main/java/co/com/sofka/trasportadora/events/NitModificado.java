package co.com.sofka.trasportadora.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.trasportadora.values.Nit;

public class NitModificado extends DomainEvent {
    private  final Nit nit;

    public NitModificado(Nit nit) {
        super("sofka.trasportadora.event.NitModificado");
        this.nit = nit;
    }

    public Nit getNit() {
        return nit;
    }
}
