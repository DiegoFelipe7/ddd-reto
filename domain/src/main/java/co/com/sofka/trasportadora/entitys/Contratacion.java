package co.com.sofka.trasportadora.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.pasajero.values.Descripcion;
import co.com.sofka.trasportadora.values.Años;
import co.com.sofka.trasportadora.values.IdContratacion;
import co.com.sofka.trasportadora.values.Monto;
import co.com.sofka.trasportadora.values.Motivo;
/**
 * Entity Contratacion
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Contratacion extends Entity<IdContratacion> {
    private Años años;
    private Monto monto;
    private Motivo motivo;
    private Descripcion descripcion;

    public Contratacion(IdContratacion entityId, Años años, Monto monto, Motivo motivo, Descripcion descripcion) {
        super(entityId);
        this.años = años;
        this.monto = monto;
        this.motivo = motivo;
        this.descripcion = descripcion;
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

