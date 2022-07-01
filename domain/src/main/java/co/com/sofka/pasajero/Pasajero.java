package co.com.sofka.pasajero;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalues.Destino;
import co.com.sofka.genericvalues.Estado;
import co.com.sofka.genericvalues.Identificacion;
import co.com.sofka.genericvalues.Nombre;
import co.com.sofka.pasajero.entitys.Asiento;
import co.com.sofka.pasajero.entitys.Equipaje;
import co.com.sofka.pasajero.entitys.Ticket;
import co.com.sofka.pasajero.events.AsientoAsociado;
import co.com.sofka.pasajero.events.EquipajeRegistrado;
import co.com.sofka.pasajero.events.PasajeroCreado;
import co.com.sofka.pasajero.events.TicketComprado;
import co.com.sofka.pasajero.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Pasajero extends AggregateEvent<IdPasajero>{
    protected Nombre nombre;
    protected Identificacion identificacion;
    protected Asiento asiento;
    protected Set<Ticket> ticket;
    protected Set<Equipaje> equipaje;
    public Pasajero(IdPasajero entityId) {
        super(entityId);
        subscribe(new PasajeroEventChangue(this));
    }

    public Pasajero(IdPasajero idPasajero, Nombre nombre, Identificacion identificacion, IdAsiento asiento) {
        super(idPasajero);
        appendChange(new PasajeroCreado(nombre,identificacion,asiento)).apply();
    }

    public static Pasajero pasajero(IdPasajero idPasajero , List<DomainEvent> events){
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
