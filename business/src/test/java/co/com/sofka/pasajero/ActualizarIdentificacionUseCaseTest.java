package co.com.sofka.pasajero;

import co.com.sofka.bus.events.PlacaActualizada;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Estado;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.commands.ActualizarIdentificacion;
import co.com.sofka.pasajero.entitys.Asiento;
import co.com.sofka.pasajero.events.IdentificacionActualizada;
import co.com.sofka.pasajero.events.PasajeroCreado;
import co.com.sofka.pasajero.values.IdAsiento;
import co.com.sofka.pasajero.values.IdPasajero;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.List;

public class ActualizarIdentificacionUseCaseTest {
    private ActualizarIdentificacionUseCase actualizarIdentificacionUseCase;

    DomainEventRepository repository;

    @Before
    public void test(){
        actualizarIdentificacionUseCase = new ActualizarIdentificacionUseCase();
        repository= Mockito.mock(DomainEventRepository.class);
        actualizarIdentificacionUseCase.addRepository(repository);
    }
    @Test
    public void ActualizarIdentificacionPasajero(){
        var command = new ActualizarIdentificacion(IdPasajero.of("1"),new Identificacion(1058788349));
        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventActualizarIdentificacion());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(actualizarIdentificacionUseCase,new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        //assert
        IdentificacionActualizada identificacionActualizadaCase = (IdentificacionActualizada) events.get(0);
        Assertions.assertEquals("sofka.pasajero.event.IdentificacionActualizada" ,identificacionActualizadaCase.type);
        Assertions.assertEquals(1058788349,identificacionActualizadaCase.getIdentificacion().value());
    }

    public List<DomainEvent> eventActualizarIdentificacion(){
        IdPasajero idPasajero = new IdPasajero("12");
        Nombre nombre = new Nombre("Diego");
        Identificacion identificacion = new Identificacion(1058788349);
        Asiento asiento = new Asiento(IdAsiento.of("12s"),new Identificacion(12),new Estado(true));
        return List.of(new PasajeroCreado(nombre,identificacion,asiento));
    }

}
