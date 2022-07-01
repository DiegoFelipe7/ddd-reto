package co.com.sofka.bus.events;

import co.com.sofka.bus.entitys.Bodega;
import co.com.sofka.bus.entitys.Conductor;
import co.com.sofka.bus.entitys.Ruta;
import co.com.sofka.bus.values.IdBus;
import co.com.sofka.bus.values.Marca;
import co.com.sofka.bus.values.Placa;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalues.Capacidad;
import co.com.sofka.pasajero.Pasajero;
import co.com.sofka.pasajero.values.IdPasajero;

import java.util.Set;

public class BusCreado extends DomainEvent {
    private final Marca marca;
    private final Placa placa;
    private final Capacidad capacidad;
    private final Set<IdPasajero> idPasajero;
    private final Set<Ruta> rutaSet;
    private final Conductor conductor;
    private final Bodega bodega;

    public BusCreado(Marca marca, Placa placa, Capacidad capacidad,
                     Set<IdPasajero> idPasajero, Set<Ruta> rutaSet, Conductor conductor, Bodega bodega) {
        super("sofka.bus.event.BusCreado");

        this.marca = marca;
        this.placa = placa;
        this.capacidad = capacidad;
        this.idPasajero = idPasajero;
        this.rutaSet = rutaSet;
        this.conductor = conductor;
        this.bodega = bodega;
    }


    public Marca getMarca() {
        return marca;
    }

    public Placa getPlaca() {
        return placa;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }

    public Set<IdPasajero> getPasajeroSet() {
        return idPasajero;
    }

    public Set<Ruta> getRutaSet() {
        return rutaSet;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public Bodega getBodega() {
        return bodega;
    }
}
