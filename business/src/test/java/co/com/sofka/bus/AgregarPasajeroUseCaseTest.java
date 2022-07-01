package co.com.sofka.bus;

import co.com.sofka.bus.commands.AgregarPasajero;
import co.com.sofka.bus.commands.CrearBus;
import co.com.sofka.bus.entitys.Bodega;
import co.com.sofka.bus.entitys.Conductor;
import co.com.sofka.bus.entitys.Ruta;
import co.com.sofka.bus.events.BusCreado;
import co.com.sofka.bus.events.PasajerosAgregados;
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
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AgregarPasajeroUseCaseTest {
    private AgregarPasajeroUseCase agregarPasajeroUseCase;
    private DomainEventRepository repository;
    @Before
    public void setUp(){
        agregarPasajeroUseCase = new AgregarPasajeroUseCase();
        repository= Mockito.mock(DomainEventRepository.class);
        agregarPasajeroUseCase.addRepository(repository);
    }
    @Test
    public void agregarPasajeroBus(){
        var command= new AgregarPasajero(IdBus.of("22"), IdPasajero.of("2"));
        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventsPasajeroAgregado());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("22")
                .syncExecutor(agregarPasajeroUseCase , new RequestCommand<>(command))
                .orElseThrow();
        var event = response.getDomainEvents();
        PasajerosAgregados pasajeroAgregadoBus =(PasajerosAgregados)  event.get(0);
        Assertions.assertEquals("sofka.bus.event.PasajerosAgregados" ,pasajeroAgregadoBus.type);


    }

    private List<DomainEvent> eventsPasajeroAgregado(){
        Set<IdPasajero> pasajeroSet = new HashSet<>();
        Set<Ruta> rutaSet = new HashSet<>();
        Marca marca = new Marca("Toyota");
        Placa placa = new Placa("XYH04E");
        Capacidad capacidad = new Capacidad(30);
        pasajeroSet.add(IdPasajero.of("1"));
        Conductor conductor = new Conductor(IdConductor.of("12"), new Nombre("Diego"),new Licencia("105887asd") , new Identificacion(1058788349));
        Bodega bodega = new Bodega(IdBodega.of("12"), new Estado(false) , new Capacidad(50));
        return List.of(new BusCreado(marca,placa,capacidad,pasajeroSet,rutaSet,conductor,bodega));
    }

}
