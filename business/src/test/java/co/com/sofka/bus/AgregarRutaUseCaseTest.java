package co.com.sofka.bus;


import co.com.sofka.bus.commands.AgregarRuta;
import co.com.sofka.bus.entitys.Bodega;
import co.com.sofka.bus.entitys.Conductor;
import co.com.sofka.bus.entitys.Ruta;
import co.com.sofka.bus.events.BusCreado;
import co.com.sofka.bus.events.RutasAgregadas;
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

import static org.mockito.Mockito.when;

public class AgregarRutaUseCaseTest {
    private AgregarRutaUseCase agregarRutaUseCase;
    private DomainEventRepository repository;
    @Before
    public void setUp(){
        agregarRutaUseCase = new AgregarRutaUseCase();
        repository= Mockito.mock(DomainEventRepository.class);
        agregarRutaUseCase.addRepository(repository);
    }

    @Test
    public void agregarRutasBus(){
        IdBus idBus = new IdBus("10");
        IdRuta idRuta = new IdRuta("50");
        Salida salida = new Salida("Popayan");
        Destino destino = new Destino("Rosas");
        Kilometro kilometro = new Kilometro(50);
        var command = new AgregarRuta(idBus,idRuta,salida,destino,kilometro);

        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventAgregarRutas());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("10")
                .syncExecutor(agregarRutaUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        RutasAgregadas rutasAgregadas= (RutasAgregadas) events.get(0);
        Assertions.assertEquals("Popayan",rutasAgregadas.getSalida().value());
        Assertions.assertEquals("Rosas",rutasAgregadas.getDestino().value());
    }

    public List<DomainEvent> eventAgregarRutas(){
        Set<IdPasajero> pasajeroSet = new HashSet<>();
        Set<Ruta> rutaSet = new HashSet<>();
        rutaSet.add(new Ruta(IdRuta.of("22"),new Salida("Popayan") , new Destino("Cali"),new Kilometro(30)));
        Marca marca = new Marca("Toyota");
        Placa placa = new Placa("XYH04E");
        Capacidad capacidad = new Capacidad(30);
        pasajeroSet.add(IdPasajero.of("1"));
        Conductor conductor = new Conductor(IdConductor.of("12"), new Nombre("Diego"),new Licencia("105887asd") , new Identificacion(1058788349));
        Bodega bodega = new Bodega(IdBodega.of("12"), new Estado(false) , new Capacidad(50));
        return List.of(new BusCreado(marca,placa,capacidad,pasajeroSet,rutaSet,conductor,bodega));
    }
}
