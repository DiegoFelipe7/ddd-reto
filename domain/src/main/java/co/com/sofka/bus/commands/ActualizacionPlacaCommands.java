package co.com.sofka.bus.commands;

import co.com.sofka.bus.values.IdBus;
import co.com.sofka.bus.values.Placa;
import co.com.sofka.domain.generic.Command;

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
