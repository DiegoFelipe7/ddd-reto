package co.com.sofka.pasajero.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.pasajero.values.IdPasajero;

/**
 * Comando para Actualizar la identificacion de un pasajero
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
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
