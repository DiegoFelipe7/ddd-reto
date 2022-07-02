package co.com.sofka.trasportadora.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.trasportadora.values.IdCede;
import co.com.sofka.trasportadora.values.Ubicacion;
/**
 * DomainEvent CedeNueva
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class CedeNuevaCreada extends DomainEvent {
    private IdCede idCede;
    private final Nombre nombre;
    private final Ubicacion ubicacion;

    public CedeNuevaCreada(IdCede idCede, Nombre nombre, Ubicacion ubicacion) {
        super("sofka.trasportadora.event.CedeNuevaCreada");
        this.idCede=idCede;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public IdCede getIdCede() {
        return idCede;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
