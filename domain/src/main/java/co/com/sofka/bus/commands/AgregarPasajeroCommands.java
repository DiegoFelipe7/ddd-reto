package co.com.sofka.bus.commands;

import co.com.sofka.bus.values.IdBus;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.pasajero.values.IdPasajero;
/**
 * Comando para agregar un pasajero
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
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
