package co.com.sofka.bus.entitys;

import co.com.sofka.bus.values.Destino;
import co.com.sofka.bus.values.IdRuta;
import co.com.sofka.bus.values.Kilometro;
import co.com.sofka.bus.values.Salida;
import co.com.sofka.domain.generic.Entity;

public class Ruta extends Entity<IdRuta> {
    private  Salida salida;
    private  Destino destino;
    private  Kilometro kilometro;

    public Ruta(IdRuta entityId, Salida salida, Destino destino, Kilometro kilometro) {
        super(entityId);
        this.salida = salida;
        this.destino = destino;
        this.kilometro = kilometro;
    }

    public Salida getSalida() {
        return salida;
    }

    public Destino getDestino() {
        return destino;
    }

    public Kilometro getKilometro() {
        return kilometro;
    }
}
