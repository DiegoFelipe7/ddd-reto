package co.com.sofka.bus.entitys;

import co.com.sofka.genericvalue.Capacidad;
import co.com.sofka.bus.values.IdBodega;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.genericvalue.Estado;

/**
 * Entity Bodega
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Bodega extends Entity<IdBodega> {
    private Estado estado;
    private Capacidad capacidad;

    public Bodega(IdBodega entityId, Estado estado, Capacidad capacidad) {
        super(entityId);
        this.estado = estado;
        this.capacidad = capacidad;
    }
    public void validarCapacacida(Capacidad capacidad){
        this.capacidad=capacidad;
    }

    public Estado getEstado() {
        return estado;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }
}
