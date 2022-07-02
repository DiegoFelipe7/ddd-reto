package co.com.sofka.trasportadora.commands;

import co.com.sofka.bus.values.IdBus;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.trasportadora.values.IdTrasportadora;

/**
 * Comando para contratar un bus
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
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
