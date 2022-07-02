package co.com.sofka.trasportadora;

import co.com.sofka.bus.Bus;
import co.com.sofka.bus.values.IdBus;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.values.Descripcion;
import co.com.sofka.trasportadora.entitys.Cedes;
import co.com.sofka.trasportadora.entitys.Contratacion;
import co.com.sofka.trasportadora.entitys.Nomina;
import co.com.sofka.trasportadora.events.*;
import co.com.sofka.trasportadora.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;
/**
 * Agregado  raiz  Trasportadora
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-06-29
 * @since 1.0.0
 * *
 */
public class Trasportadora extends AggregateEvent<IdTrasportadora> {
    protected Nit nit;
    protected Nombre nombre;
    protected Set<IdBus> idBuses;
    protected Nomina nomina;
    protected Set<Contratacion> contratacionSet;
    protected Set<Cedes> cedesSet;

    public Trasportadora(IdTrasportadora entityId) {
        super(entityId);
        subscribe(new TrasportadoraEventChangue(this));
    }

    public Trasportadora(IdTrasportadora entityId, Nit nit, Nombre nombre, Set<IdBus> busSet, Nomina nomina, Set<Contratacion> contratacionSet, Set<Cedes> cedesSet) {
        super(entityId);
        appendChange(new TrasportadoraCreada(nit,nombre,busSet,nomina,contratacionSet,cedesSet)).apply();
    }

    public static Trasportadora from (IdTrasportadora idTrasportadora , List<DomainEvent> events){
        var trasportadora = new Trasportadora(idTrasportadora);
        events.forEach(trasportadora::applyEvent);
        return  trasportadora;
    }

    public void contratarBus(IdBus idBus){
        Objects.requireNonNull(idBus,"No se permiten vacios");
        appendChange(new BusContratado(idBus));
    }

    public void crearNuevaCede(IdCede idCede, Nombre nombre, Ubicacion ubicacion){
        Objects.requireNonNull(idCede,"No se permiten valores vacios");
        Objects.requireNonNull(nombre,"No se permiten valores vacios");
        Objects.requireNonNull(ubicacion,"No se permiten valores vacios");
        appendChange(new CedeNuevaCreada(idCede,nombre,ubicacion));

    }

    public void ModificarNit(Nit nit){
        Objects.requireNonNull(nit,"No se permiten valores vacios");
        appendChange(new NitModificado(nit));
    }

    public void NuevaContratacion(IdContratacion idContratacion, Años años, Monto monto, Motivo motivo, Descripcion descripcion){
        Objects.requireNonNull(idContratacion,"No se permite campos vacios");
        Objects.requireNonNull(años,"No se permite campos vacios");
        Objects.requireNonNull(monto,"No se permite campos vacios");
        Objects.requireNonNull(motivo,"No se permite campos vacios");
        Objects.requireNonNull(descripcion,"No se permite campos vacios");
        appendChange(new ContratacionRealizada(idContratacion,años,monto,motivo,descripcion));

    }
}
