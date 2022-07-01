package co.com.sofka.trasportadora.commands;

import co.com.sofka.bus.values.IdBus;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.trasportadora.values.IdTrasportadora;

public class ContrararBus extends Command {
    private IdTrasportadora idTrasportadora;
    private IdBus idBus;

    public ContrararBus(IdTrasportadora idTrasportadora, IdBus idBus) {
        this.idTrasportadora = idTrasportadora;
        this.idBus = idBus;
    }

    public IdTrasportadora getIdTrasportadora() {
        return idTrasportadora;
    }

    public void setIdTrasportadora(IdTrasportadora idTrasportadora) {
        this.idTrasportadora = idTrasportadora;
    }

    public IdBus getIdBus() {
        return idBus;
    }

    public void setIdBus(IdBus idBus) {
        this.idBus = idBus;
    }
}
