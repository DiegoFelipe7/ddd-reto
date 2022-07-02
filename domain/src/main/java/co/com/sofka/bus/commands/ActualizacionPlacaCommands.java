package co.com.sofka.bus.commands;

import co.com.sofka.bus.values.IdBus;
import co.com.sofka.bus.values.Placa;
import co.com.sofka.domain.generic.Command;
/**
 * Comando para actualizar la placa de un bus
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class ActualizacionPlacaCommands extends Command {
    private final IdBus idBus;
    private final Placa placa;

    public ActualizacionPlacaCommands(IdBus idBus, Placa placa) {
        this.idBus = idBus;
        this.placa = placa;
    }

    public IdBus getIdBus() {
        return idBus;
    }

    public Placa getPlaca() {
        return placa;
    }
}
