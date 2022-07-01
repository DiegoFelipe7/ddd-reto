package co.com.sofka.bus;

import co.com.sofka.bus.commands.ActualizacionPlacaCommands;
import co.com.sofka.bus.entitys.Bodega;
import co.com.sofka.bus.entitys.Conductor;
import co.com.sofka.bus.entitys.Ruta;
import co.com.sofka.bus.events.BusCreado;
import co.com.sofka.bus.events.PlacaActualizada;
import co.com.sofka.bus.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Capacidad;
import co.com.sofka.genericvalue.Estado;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.values.IdPasajero;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActualizarPlacaUseCaseTest {


    private ActualizarPlacaUseCase actualizarPlacaUseCase;
    DomainEventRepository repository;
    @BeforeEach
    public void setUp(){
        actualizarPlacaUseCase= new ActualizarPlacaUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        actualizarPlacaUseCase.addRepository(repository);
    }
    @Test
   public void ActualizarPlacaBus(){
        //arrage
        var command = new ActualizacionPlacaCommands(IdBus.of("125"),new Placa("PWA12E"));
        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventPlacaActualizada());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("125")
                .syncExecutor(actualizarPlacaUseCase,new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        //assert
        PlacaActualizada actualizacionPlacaTest = (PlacaActualizada) events.get(0);
        Assertions.assertEquals("sofka.bus.event.PlacaActualizada" ,actualizacionPlacaTest.type);
        Assertions.assertEquals("PWA12E",actualizacionPlacaTest.getPlaca().value());
    }
    public List<DomainEvent> eventPlacaActualizada(){
        Set<IdPasajero> pasajeroSet = new HashSet<>();
        Set<Ruta> rutaSet = new HashSet<>();
        Marca marca = new Marca("Toyota");
        Placa placa = new Placa("XYH04E");
        Capacidad capacidad = new Capacidad(11);
        pasajeroSet.add(IdPasajero.of("1"));
        Conductor conductor = new Conductor(IdConductor.of("12"), new Nombre("Diego"),new Licencia("105887asd") , new Identificacion(1058788349));
        Bodega bodega = new Bodega(IdBodega.of("12"), new Estado(false) , new Capacidad(50));
        return List.of(new BusCreado(marca,placa,capacidad,pasajeroSet,rutaSet,conductor,bodega));
    }


}
