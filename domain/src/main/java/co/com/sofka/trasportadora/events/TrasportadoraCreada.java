package co.com.sofka.trasportadora.events;

import co.com.sofka.bus.Bus;
import co.com.sofka.bus.values.IdBus;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.trasportadora.entitys.Cedes;
import co.com.sofka.trasportadora.entitys.Contratacion;
import co.com.sofka.trasportadora.entitys.Nomina;
import co.com.sofka.trasportadora.values.Nit;

import java.util.Set;
/**
 * DomainEvent TrasportadoraCreada
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class TrasportadoraCreada extends DomainEvent {
    private final Nit nit;
    private final Nombre nombre;
    private final Set<IdBus> busSet;
    private final Nomina nomina;
    private final Set<Contratacion> contratacionSet;
    private final Set<Cedes> cedesSet;

    public TrasportadoraCreada( Nit nit, Nombre nombre, Set<IdBus> busSet, Nomina nomina, Set<Contratacion> contratacionSet, Set<Cedes> cedesSet) {
        super("sofka.trasportadora.event.TrasportadoraCreada");
        this.nit = nit;
        this.nombre = nombre;
        this.busSet = busSet;
        this.nomina = nomina;
        this.contratacionSet = contratacionSet;
        this.cedesSet = cedesSet;
    }

    public Nit getNit() {
        return nit;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Set<IdBus> getBusSet() {
        return busSet;
    }

    public Nomina getNomina() {
        return nomina;
    }

    public Set<Contratacion> getContratacionSet() {
        return contratacionSet;
    }

    public Set<Cedes> getCedesSet() {
        return cedesSet;
    }
}
