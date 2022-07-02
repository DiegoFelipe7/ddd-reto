package co.com.sofka.pasajero;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Destino;
import co.com.sofka.genericvalue.Estado;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.entitys.Asiento;
import co.com.sofka.pasajero.entitys.Equipaje;
import co.com.sofka.pasajero.entitys.Ticket;
import co.com.sofka.pasajero.events.*;
import co.com.sofka.pasajero.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;
/**
 * Agregado  raiz  Pasajero
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 * *
 */
public class Pasajero extends AggregateEvent<IdPasajero>{
    protected Nombre nombre;
    protected Identificacion identificacion;

    protected Set<Ticket> ticket;
    protected Set<Equipaje> equipaje;

    protected Asiento asiento;
    public Pasajero(IdPasajero entityId) {
        super(entityId);
        subscribe(new PasajeroEventChangue(this));
    }

    public Pasajero(IdPasajero entityId, Nombre nombre, Identificacion identificacion, Set<Ticket> ticket, Set<Equipaje> equipaje, Asiento asiento) {
        super(entityId);
        appendChange(new PasajeroCreado(nombre,identificacion,ticket,equipaje,asiento)).apply();
    }

    public static Pasajero from(IdPasajero idPasajero , List<DomainEvent> events){
        var pasajero = new Pasajero(idPasajero);
        events.forEach(pasajero::applyEvent);
        return pasajero;
    }
    public void ComprarTicket(IdTicket idTicket, Precio precio, Destino destino, Fecha fecha, Estado estado){
        Objects.requireNonNull(idTicket);
        Objects.requireNonNull(precio);
        Objects.requireNonNull(destino);
        Objects.requireNonNull(fecha);
        Objects.requireNonNull(estado);
        appendChange(new TicketComprado(idTicket,precio,destino,fecha,estado));
    }

    public void RegistrarEquipaje(IdEquipaje idEquipaje, Peso peso, Descripcion descripcion){
        Objects.requireNonNull(idEquipaje);
        Objects.requireNonNull(peso);
        Objects.requireNonNull(descripcion);
        appendChange(new EquipajeRegistrado(idEquipaje,peso,descripcion));

    }
    public void asociarAsiento(IdAsiento idAsiento, Identificacion identificacion, Estado estado){
        Objects.requireNonNull(idAsiento);
        Objects.requireNonNull(identificacion);
        Objects.requireNonNull(estado);
        appendChange(new AsientoAsociado(idAsiento,identificacion,estado));
    }
    public void CancelarTicker(){

    }

    public void ActualizarIdentificacion(Identificacion identificacion){
        Objects.requireNonNull(identificacion,"Campo obligatorio");
        appendChange(new IdentificacionActualizada(identificacion));
    }


    public Nombre Nombre() {
        return nombre;
    }

    public Identificacion Identificacion() {
        return identificacion;
    }

    public Asiento Asiento() {
        return asiento;
    }

    public Set<Ticket> Ticket() {
        return ticket;
    }

    public Set<Equipaje> Equipaje() {
        return equipaje;
    }
}
