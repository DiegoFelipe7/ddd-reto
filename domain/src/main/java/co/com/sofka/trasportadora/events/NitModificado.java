package co.com.sofka.trasportadora.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.trasportadora.values.Nit;
/**
 * DomainEvent NitModificado
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
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
