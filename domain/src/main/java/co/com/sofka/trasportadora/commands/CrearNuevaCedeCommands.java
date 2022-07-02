package co.com.sofka.trasportadora.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.trasportadora.values.IdCede;
import co.com.sofka.trasportadora.values.IdTrasportadora;
import co.com.sofka.trasportadora.values.Ubicacion;

public class CrearNuevaCedeCommands extends Command {
    private final IdTrasportadora idTrasportadora;
    private final IdCede idCede;
    private final Nombre nombre;
    private final Ubicacion ubicacion;

    public CrearNuevaCedeCommands(IdTrasportadora idTrasportadora, IdCede idCede, Nombre nombre, Ubicacion ubicacion) {
        this.idTrasportadora = idTrasportadora;
        this.idCede = idCede;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public IdTrasportadora getIdTrasportadora() {
        return idTrasportadora;
    }

    public IdCede getIdCede() {
        return idCede;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
