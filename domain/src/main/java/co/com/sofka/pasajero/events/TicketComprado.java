package co.com.sofka.pasajero.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Estado;
import co.com.sofka.pasajero.values.Fecha;
import co.com.sofka.pasajero.values.IdTicket;
import co.com.sofka.pasajero.values.Precio;
import co.com.sofka.genericvalue.Destino;
/**
 * DomainEvent TicketComprado
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class TicketComprado extends DomainEvent {
    private final IdTicket idTicket;
    private final Precio precio;
    private final Destino destino;
    private final Fecha fecha;
    private final Estado estado;

    public TicketComprado(IdTicket idTicket,Precio precio , Destino destino , Fecha fecha , Estado estado){
        super("sofka.pasajero.event.TicketComprado");
        this.idTicket=idTicket;
        this.precio=precio;
        this.destino=destino;
        this.fecha=fecha;
        this.estado=estado;
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
