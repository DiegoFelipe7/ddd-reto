package co.com.sofka.pasajero.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.entitys.Asiento;
import co.com.sofka.pasajero.values.IdAsiento;
import co.com.sofka.pasajero.values.IdPasajero;

public class CrearPasajero extends Command {
    private final IdPasajero idPasajero;
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Asiento asiento;

    public CrearPasajero(IdPasajero idPasajero, Nombre nombre, Identificacion identificacion, Asiento asiento) {
        this.idPasajero = idPasajero;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.asiento = asiento;
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

    public Asiento getIdAsiento() {
        return asiento;
    }
}
