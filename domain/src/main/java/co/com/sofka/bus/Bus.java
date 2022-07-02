package co.com.sofka.bus;

import co.com.sofka.bus.entitys.Bodega;
import co.com.sofka.bus.entitys.Conductor;
import co.com.sofka.bus.entitys.Ruta;
import co.com.sofka.bus.events.BusCreado;
import co.com.sofka.bus.events.PasajerosAgregados;
import co.com.sofka.bus.events.PlacaActualizada;
import co.com.sofka.bus.events.RutasAgregadas;
import co.com.sofka.bus.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Capacidad;
import co.com.sofka.pasajero.values.IdPasajero;

import java.util.List;
import java.util.Objects;
import java.util.Set;
/**
 * Agregado  raiz  Bus
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-07
 * @since 1.0.0
 * *
 */
public class Bus extends AggregateEvent<IdBus> {
    protected Marca marca;
    protected Placa placa;
    protected Capacidad capacidad;
    protected Set<IdPasajero> idPasajeros;
    protected Set<Ruta> rutaSet;
    protected Conductor conductor;
    protected Bodega bodega;

    public Bus(IdBus idBus) {
        super(idBus);
        subscribe(new BusEventChangue(this));
    }

    public Bus(IdBus idBus, Marca marca, Placa placa, Capacidad capacidad, Set<IdPasajero> idPasajeros,
               Set<Ruta> rutaSet, Conductor conductor, Bodega bodega) {
        super(idBus);
        this.marca = marca;
        this.placa = placa;
        this.capacidad = capacidad;
        this.idPasajeros = idPasajeros;
        this.rutaSet = rutaSet;
        this.conductor = conductor;
        this.bodega = bodega;
        appendChange(new BusCreado(marca,placa,capacidad,idPasajeros,rutaSet,conductor,bodega)).apply();
        subscribe(new BusEventChangue(this));
    }
    public static Bus from (IdBus idBus , List<DomainEvent> events){
        var bus =new Bus(idBus);
        events.forEach(bus::applyEvent);
        return bus;
    }

    public void ActualizarPlaca(Placa placa){
        Objects.requireNonNull(placa,"Placa Requerida");
        appendChange( new PlacaActualizada(placa));
    }

    public void agregarPasajeros(IdPasajero idPasajero){
        Objects.requireNonNull(idPasajero,"Campo obligatorio");
        appendChange(new PasajerosAgregados(idPasajero));
    }

    public void agregarRuta(IdRuta idRuta , Salida salida ,Destino destino , Kilometro kilometro){
        Objects.requireNonNull(idRuta,"Campo obligatorio");
        Objects.requireNonNull(salida,"Campo obligatorio");
        Objects.requireNonNull(destino,"Campo obligatorio");
        Objects.requireNonNull(kilometro,"Campo obligatorio");
        appendChange(new RutasAgregadas(idRuta,salida,destino,kilometro));
    }

}
