package co.com.sofka.bus.commands;

import co.com.sofka.bus.values.Destino;
import co.com.sofka.bus.values.IdRuta;
import co.com.sofka.bus.values.Kilometro;
import co.com.sofka.bus.values.Salida;
import co.com.sofka.domain.generic.Command;

public class AgregarRuta extends Command {
    private final IdRuta  idRuta;
    private final Salida salida;
    private final Destino destino;
    private final Kilometro kilometro;

    public AgregarRuta(IdRuta idRuta, Salida salida, Destino destino, Kilometro kilometro) {
        this.idRuta = idRuta;
        this.salida = salida;
        this.destino = destino;
        this.kilometro = kilometro;
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
