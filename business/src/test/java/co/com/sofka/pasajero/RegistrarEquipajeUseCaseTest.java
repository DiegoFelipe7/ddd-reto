package co.com.sofka.pasajero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Destino;
import co.com.sofka.genericvalue.Estado;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.commands.RegistrarEquipajeCommands;
import co.com.sofka.pasajero.entitys.Asiento;
import co.com.sofka.pasajero.entitys.Equipaje;
import co.com.sofka.pasajero.entitys.Ticket;
import co.com.sofka.pasajero.events.EquipajeRegistrado;
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
/**
 * Test para registrar el equipaje de un pasajero
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class RegistrarEquipajeUseCaseTest {
    private RegistrarEquipajeUseCase registrarEquipajeUseCase;
    DomainEventRepository repository;

    @Before
    public void setUp(){
        registrarEquipajeUseCase = new RegistrarEquipajeUseCase();
        repository= Mockito.mock(DomainEventRepository.class);
        registrarEquipajeUseCase.addRepository(repository);
    }
    @Test
    public void registarEquipajePasajero(){
        IdPasajero idPasajero = new IdPasajero("1");
        IdEquipaje idEquipaje = new IdEquipaje("2");
        Peso peso = new Peso(20);
        Descripcion descripcion = new Descripcion("Maleta roja");
        var command = new RegistrarEquipajeCommands(idPasajero,idEquipaje,peso,descripcion);

        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventRegistrarEquipaje());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(registrarEquipajeUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        EquipajeRegistrado equipajeRegistradoTest= (EquipajeRegistrado) events.get(0);
        Assertions.assertEquals("Maleta roja",equipajeRegistradoTest.getDescripcion().value());
    }
    public List<DomainEvent> eventRegistrarEquipaje(){
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
