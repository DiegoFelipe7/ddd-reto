package co.com.sofka.bus.commands;

import co.com.sofka.bus.entitys.Bodega;
import co.com.sofka.bus.entitys.Conductor;
import co.com.sofka.bus.entitys.Ruta;
import co.com.sofka.bus.values.IdBus;
import co.com.sofka.bus.values.Marca;
import co.com.sofka.bus.values.Placa;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.genericvalue.Capacidad;
import co.com.sofka.pasajero.values.IdPasajero;

import java.util.Set;

/**
 * Comando para crear un bus
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class CrearBusCommands extends Command {
    private final IdBus idBus;
    private final Marca marca;
    private final Placa placa;
    private final Capacidad capacidad;
    private final Set<IdPasajero> idPasajero;
    private final Set<Ruta> rutaSet;
    private final Conductor conductor;
    private final Bodega bodega;

    public CrearBusCommands(IdBus idBus, Marca marca, Placa placa, Capacidad capacidad, Set<IdPasajero> idPasajero, Set<Ruta> rutaSet, Conductor conductor, Bodega bodega) {
        this.idBus = idBus;
        this.marca = marca;
        this.placa = placa;
        this.capacidad = capacidad;
        this.idPasajero = idPasajero;
        this.rutaSet = rutaSet;
        this.conductor = conductor;
        this.bodega = bodega;
    }

    public IdBus getIdBus() {
        return idBus;
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

    public Set<IdPasajero> getIdPasajero() {
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
