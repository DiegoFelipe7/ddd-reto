package co.com.sofka.pasajero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.genericvalue.Destino;
import co.com.sofka.genericvalue.Estado;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.commands.CrearPasajeroCommands;
import co.com.sofka.pasajero.entitys.Asiento;
import co.com.sofka.pasajero.entitys.Equipaje;
import co.com.sofka.pasajero.entitys.Ticket;
import co.com.sofka.pasajero.events.PasajeroCreado;
import co.com.sofka.pasajero.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
/**
 * Test para crear un pasajero
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
public class CrearPasajeroCommandsUseCaseTest {
    @InjectMocks
    private CrearPasajeroUseCase crearPasajeroUseCase;

    @Mock
    DomainEventRepository repository;

    @Test
    public void CrearPasajero() {
        IdPasajero idPasajero = new IdPasajero("12");
        Nombre nombre = new Nombre("Diego");
        Identificacion identificacion = new Identificacion(1058788349);
        Set<Ticket> ticketSet = new HashSet<>();
        ticketSet.add(new Ticket(IdTicket.of("1") , new Precio(3.00),new Destino("Popayan"),new Fecha(LocalDate.now()),new Estado(true) ));
        Set<Equipaje> equipajeSet = new HashSet<>();
        equipajeSet.add(new Equipaje(IdEquipaje.of("1"),new Peso(10) , new Descripcion("Maleta de mano")));
        Asiento asiento = new Asiento(IdAsiento.of("1"),new Identificacion(12),new Estado(true));

        var command = new CrearPasajeroCommands(idPasajero,nombre,identificacion,ticketSet,equipajeSet,asiento);

        var events = UseCaseHandler
                .getInstance().syncExecutor(crearPasajeroUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assertion
        var event =(PasajeroCreado) events.get(0);
        Assertions.assertEquals("Diego",event.getNombre().value());
    }
}
