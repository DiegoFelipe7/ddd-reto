package co.com.sofka.bus.commands;

import co.com.sofka.bus.values.IdBus;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.pasajero.values.IdPasajero;

public class AgregarPasajeroCommands extends Command {
    private final IdBus idBus;
    private final IdPasajero idPasajero;

    public AgregarPasajeroCommands(IdBus idBus, IdPasajero idPasajero) {
        this.idBus = idBus;
        this.idPasajero = idPasajero;
    }

    public IdBus getIdBus() {
        return idBus;
    }

    public IdPasajero getIdPasajero() {
        return idPasajero;
    }
}
