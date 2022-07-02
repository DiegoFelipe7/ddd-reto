package co.com.sofka.pasajero.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Estado;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.pasajero.values.IdAsiento;
/**
 * DomainEvent AsientoAsociado
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class AsientoAsociado extends DomainEvent {
    private final IdAsiento idAsiento;
    private final Identificacion identificacion;
    private final Estado estado;

    public AsientoAsociado(IdAsiento idAsiento, Identificacion identificacion, Estado estado) {
        super("sofka.pasajero.event.AsientoAsociado");
        this.idAsiento = idAsiento;
        this.identificacion = identificacion;
        this.estado = estado;
    }

    public IdAsiento getIdAsiento() {
        return idAsiento;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public Estado getEstado() {
        return estado;
    }
}
