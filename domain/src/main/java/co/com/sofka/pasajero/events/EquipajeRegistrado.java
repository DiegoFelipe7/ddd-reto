package co.com.sofka.pasajero.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.pasajero.values.Descripcion;
import co.com.sofka.pasajero.values.IdEquipaje;
import co.com.sofka.pasajero.values.Peso;
/**
 * DomainEvent EquipajeRegistrado
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class EquipajeRegistrado extends DomainEvent {
    private final IdEquipaje idEquipaje;
    private final Peso peso;
    private final Descripcion descripcion;

    public EquipajeRegistrado(IdEquipaje idEquipaje, Peso peso, Descripcion descripcion) {
        super("sofka.pasajero.event.EquipajeRegistrado");
        this.idEquipaje = idEquipaje;
        this.peso = peso;
        this.descripcion = descripcion;
    }

    public IdEquipaje getIdEquipaje() {
        return idEquipaje;
    }

    public Peso getPeso() {
        return peso;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
