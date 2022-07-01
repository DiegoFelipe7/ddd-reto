package co.com.sofka.bus.commands;

import co.com.sofka.bus.values.*;
import co.com.sofka.domain.generic.Command;

public class AgregarRuta extends Command {
    private IdBus idBus;
    private final IdRuta  idRuta;
    private final Salida salida;
    private final Destino destino;
    private final Kilometro kilometro;

    public AgregarRuta(IdBus idBus,IdRuta idRuta, Salida salida, Destino destino, Kilometro kilometro) {
        this.idBus=idBus;
        this.idRuta = idRuta;
        this.salida = salida;
        this.destino = destino;
        this.kilometro = kilometro;
    }

    public IdBus getIdBus() {
        return idBus;
    }

    public IdRuta getIdRuta() {
        return idRuta;
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
