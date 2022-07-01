package co.com.sofka.trasportadora.commands;

import co.com.sofka.trasportadora.values.IdTrasportadora;
import co.com.sofka.trasportadora.values.Nit;

public class ModificarNit {
    private final IdTrasportadora idTrasportadora;
    private final Nit nit;

    public ModificarNit(IdTrasportadora idTrasportadora, Nit nit) {
        this.idTrasportadora = idTrasportadora;
        this.nit = nit;
    }

    public IdTrasportadora getIdTrasportadora() {
        return idTrasportadora;
    }

    public Nit getNit() {
        return nit;
    }
}
