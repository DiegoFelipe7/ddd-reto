package co.com.sofka.pasajero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Destino;
import co.com.sofka.genericvalue.Estado;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.commands.ComprarTicketCommands;
import co.com.sofka.pasajero.entitys.Asiento;
import co.com.sofka.pasajero.entitys.Equipaje;
import co.com.sofka.pasajero.entitys.Ticket;
import co.com.sofka.pasajero.events.PasajeroCreado;
import co.com.sofka.pasajero.events.TicketComprado;
import co.com.sofka.pasajero.values.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComprarTicketCommandsUseCaseTest {
    private ComprarTicketUseCase comprarTicketUseCase;

    DomainEventRepository repository;

    @Before
    public void setUp(){
        comprarTicketUseCase = new ComprarTicketUseCase();
        repository= Mockito.mock(DomainEventRepository.class);
        comprarTicketUseCase.addRepository(repository);
    }
    @Test
    public void ComprarTicketPasajero(){
        IdPasajero idPasajero = new IdPasajero("1");
        IdTicket ticket = new IdTicket("1");
        Precio precio = new Precio(38.000);
        Destino destino = new Destino("Popayan");
        Fecha fecha = new Fecha(LocalDate.now());
        Estado estado = new Estado(true);
        var command = new ComprarTicketCommands(idPasajero,ticket,precio,destino,fecha,estado);

        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventComprarTicket());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("10")
                .syncExecutor(comprarTicketUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        TicketComprado ticketCompradoTest= (TicketComprado) events.get(0);
        Assertions.assertEquals("Popayan",ticketCompradoTest.getDestino().value());
        Assertions.assertEquals(38.000,ticketCompradoTest.getPrecio().value());
    }
    public List<DomainEvent> eventComprarTicket(){
        Nombre nombre = new Nombre("Diego");
        Identificacion identificacion = new Identificacion(1058788349);
        Set<Ticket> ticketSet = new HashSet<>();
        ticketSet.add(new Ticket(IdTicket.of("1") , new Precio(3.00),new Destino("Popayan"),new Fecha(LocalDate.now()),new Estado(true) ));
        Set<Equipaje> equipajeSet = new HashSet<>();
        equipajeSet.add(new Equipaje(IdEquipaje.of("1"),new Peso(10) , new Descripcion("Maleta de mano")));
        Asiento asiento = new Asiento(IdAsiento.of("1"),new Identificacion(12),new Estado(true));
        return  List.of(new PasajeroCreado(nombre,identificacion,ticketSet,equipajeSet,asiento));
    }

}
