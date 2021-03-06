package co.com.sofka.pasajero.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.genericvalue.Destino;
import co.com.sofka.genericvalue.Estado;
import co.com.sofka.pasajero.values.Fecha;
import co.com.sofka.pasajero.values.IdPasajero;
import co.com.sofka.pasajero.values.IdTicket;
import co.com.sofka.pasajero.values.Precio;

/**
 * Comando para comprar ticket
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class ComprarTicketCommands extends Command {
    private final IdPasajero idPasajero;
    private final IdTicket idTicket;
    private final Precio precio;
    private final Destino destino;
    private final Fecha fecha;
    private final Estado estado;

    public ComprarTicketCommands(IdPasajero idPasajero, IdTicket idTicket, Precio precio, Destino destino, Fecha fecha, Estado estado) {
        this.idPasajero = idPasajero;
        this.idTicket = idTicket;
        this.precio = precio;
        this.destino = destino;
        this.fecha = fecha;
        this.estado = estado;
    }



    public IdPasajero getIdPasajero() {
        return idPasajero;
    }

    public IdTicket getIdTicket() {
        return idTicket;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Destino getDestino() {
        return destino;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Estado getEstado() {
        return estado;
    }
}
