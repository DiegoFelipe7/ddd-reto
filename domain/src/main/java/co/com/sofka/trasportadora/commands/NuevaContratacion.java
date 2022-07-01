package co.com.sofka.trasportadora.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.pasajero.values.Descripcion;
import co.com.sofka.trasportadora.values.Años;
import co.com.sofka.trasportadora.values.IdTrasportadora;
import co.com.sofka.trasportadora.values.Monto;
import co.com.sofka.trasportadora.values.Motivo;

public class NuevaContratacion extends Command {
    private final IdTrasportadora idTrasportadora;
    private final Años años;
    private final Monto monto;
    private final Motivo motivo;
    private final Descripcion descripcion;

    public NuevaContratacion(IdTrasportadora idTrasportadora, Años años, Monto monto, Motivo motivo, Descripcion descripcion) {
        this.idTrasportadora = idTrasportadora;
        this.años = años;
        this.monto = monto;
        this.motivo = motivo;
        this.descripcion = descripcion;
    }

    public IdTrasportadora getIdTrasportadora() {
        return idTrasportadora;
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
