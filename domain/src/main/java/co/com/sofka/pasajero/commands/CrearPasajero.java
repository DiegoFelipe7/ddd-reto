package co.com.sofka.pasajero.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.genericvalues.Identificacion;
import co.com.sofka.genericvalues.Nombre;
import co.com.sofka.pasajero.values.IdAsiento;
import co.com.sofka.pasajero.values.IdPasajero;

public class CrearPasajero extends Command {
    private final IdPasajero idPasajero;
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final IdAsiento idAsiento;

    public CrearPasajero(IdPasajero idPasajero, Nombre nombre, Identificacion identificacion, IdAsiento idAsiento) {
        this.idPasajero = idPasajero;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.idAsiento = idAsiento;
    }

    public IdPasajero getIdPasajero() {
        return idPasajero;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public IdAsiento getIdAsiento() {
        return idAsiento;
    }
}
