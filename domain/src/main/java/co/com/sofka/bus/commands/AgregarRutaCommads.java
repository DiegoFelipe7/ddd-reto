package co.com.sofka.bus.commands;

import co.com.sofka.bus.values.*;
import co.com.sofka.domain.generic.Command;

/**
 * Comando para agregar un ruta al bus
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class AgregarRutaCommads extends Command {
    private IdBus idBus;
    private final IdRuta  idRuta;
    private final Salida salida;
    private final Destino destino;
    private final Kilometro kilometro;

    public AgregarRutaCommads(IdBus idBus, IdRuta idRuta, Salida salida, Destino destino, Kilometro kilometro) {
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
