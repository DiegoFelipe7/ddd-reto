package co.com.sofka.trasportadora.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.pasajero.values.Descripcion;
import co.com.sofka.trasportadora.values.Años;
import co.com.sofka.trasportadora.values.IdContratacion;
import co.com.sofka.trasportadora.values.Monto;
import co.com.sofka.trasportadora.values.Motivo;
/**
 * DomainEvent ContratacionRealizada
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class ContratacionRealizada extends DomainEvent {
    private final IdContratacion idContratacion;
    private final Años años;
    private final Monto monto;
    private final Motivo motivo;
    private final Descripcion descripcion;

    public ContratacionRealizada(IdContratacion idContratacion, Años años, Monto monto, Motivo motivo, Descripcion descripcion) {
        super("sofka.trasportadora.event.ContratacionRealizada");
        this.idContratacion = idContratacion;
        this.años = años;
        this.monto = monto;
        this.motivo = motivo;
        this.descripcion = descripcion;
    }

    public IdContratacion getIdContratacion() {
        return idContratacion;
    }

    public Años getAños() {
        return años;
    }

    public Monto getMonto() {
        return monto;
    }

    public Motivo getMotivo() {
        return motivo;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
