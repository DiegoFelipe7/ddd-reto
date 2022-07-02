package co.com.sofka.pasajero.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.pasajero.values.Descripcion;
import co.com.sofka.pasajero.values.IdEquipaje;
import co.com.sofka.pasajero.values.IdPasajero;
import co.com.sofka.pasajero.values.Peso;

/**
 * Comando para registrat equipaje
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class RegistrarEquipajeCommands extends Command {
    private final IdPasajero idPasajero;
    private final IdEquipaje idEquipaje;
    private final Peso peso;
    private final Descripcion descripcion;

    public RegistrarEquipajeCommands(IdPasajero idPasajero, IdEquipaje idEquipaje, Peso peso, Descripcion descripcion) {
        this.idPasajero = idPasajero;
        this.idEquipaje = idEquipaje;
        this.peso = peso;
        this.descripcion = descripcion;
    }

    public IdPasajero getIdPasajero() {
        return idPasajero;
    }

    public IdEquipaje getIdEquipaje() {
        return idEquipaje;
    }

    public Peso getPeso() {
        return peso;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
