package co.com.sofka.pasajero.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.genericvalue.Estado;
import co.com.sofka.pasajero.values.Fecha;
import co.com.sofka.pasajero.values.IdTicket;
import co.com.sofka.pasajero.values.Precio;
import co.com.sofka.genericvalue.Destino;
/**
 * Entity Ticket
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Ticket extends Entity<IdTicket> {
    private Precio precio;
    private Destino destino;
    private Fecha fecha;
    private Estado estado;

    public Ticket(IdTicket entityId, Precio precio, Destino destino, Fecha fecha, Estado estado) {
        super(entityId);
        this.precio = precio;
        this.destino = destino;
        this.fecha = fecha;
        this.estado = estado;
    }

    public void actualizarDestino(Destino destino){
        this.destino=destino;
    }

    public void cambiarEstado(){
        this.estado=estado;
    }

}
