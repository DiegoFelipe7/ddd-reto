package co.com.sofka.pasajero.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.pasajero.values.IdPasajero;

public class ActualizarIdentificacionCommands extends Command {
    private final IdPasajero idPasajero;
    private final Identificacion identificacion;

    public ActualizarIdentificacionCommands(IdPasajero idPasajero, Identificacion identificacion) {
        this.idPasajero = idPasajero;
        this.identificacion = identificacion;
    }

    public IdPasajero getIdPasajero() {
        return idPasajero;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }
}
