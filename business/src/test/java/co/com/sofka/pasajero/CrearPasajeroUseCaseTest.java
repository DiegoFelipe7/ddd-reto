package co.com.sofka.pasajero;

import co.com.sofka.bus.events.BusCreado;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.genericvalue.Estado;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.commands.CrearPasajero;
import co.com.sofka.pasajero.entitys.Asiento;
import co.com.sofka.pasajero.events.PasajeroCreado;
import co.com.sofka.pasajero.values.IdAsiento;
import co.com.sofka.pasajero.values.IdPasajero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CrearPasajeroUseCaseTest {
    @InjectMocks
    private CrearPasajeroUseCase crearPasajeroUseCase;

    @Mock
    DomainEventRepository repository;

    @Test
    public void CrearPasajero() {
        IdPasajero idPasajero = new IdPasajero("12");
        Nombre nombre = new Nombre("Diego");
        Identificacion identificacion = new Identificacion(1058788349);
        Asiento asiento = new Asiento(IdAsiento.of("12s"),new Identificacion(12),new Estado(true));

        var command = new CrearPasajero(idPasajero,nombre,identificacion,asiento);

        var events = UseCaseHandler
                .getInstance().syncExecutor(crearPasajeroUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assertion
        var event =(PasajeroCreado) events.get(0);
        Assertions.assertEquals("Diego",event.getNombre().value());
    }
}
