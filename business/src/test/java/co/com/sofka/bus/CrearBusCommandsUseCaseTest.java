package co.com.sofka.bus;


import co.com.sofka.bus.commands.CrearBusCommands;
import co.com.sofka.bus.entitys.Bodega;
import co.com.sofka.bus.entitys.Conductor;
import co.com.sofka.bus.entitys.Ruta;
import co.com.sofka.bus.events.BusCreado;
import co.com.sofka.bus.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.genericvalue.Capacidad;
import co.com.sofka.genericvalue.Estado;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.values.IdPasajero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;
/**
 * Test para crear un bus
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
public class CrearBusCommandsUseCaseTest {

    @InjectMocks
    private  CrearBusUseCase crearBusUseCase;

    @Mock
    DomainEventRepository repository;

    @Test
    public void CrearBus(){
        Set<IdPasajero> pasajeroSet = new HashSet<>();
        Set<Ruta> rutaSet = new HashSet<>();
        IdBus idBus = new IdBus("1422");
        Marca marca = new Marca("Toyota");
        Placa placa = new Placa("XYH04E");
        Capacidad capacidad = new Capacidad(15);
        pasajeroSet.add(IdPasajero.of("1"));
        Conductor conductor = new Conductor(IdConductor.of("12"), new Nombre("Diego"),new Licencia("105887asd") , new Identificacion(1058788349));
        Bodega bodega = new Bodega(IdBodega.of("12"), new Estado(false) , new Capacidad(50));

        var command = new CrearBusCommands(idBus,marca,placa,capacidad,pasajeroSet,rutaSet,conductor,bodega);

        var events = UseCaseHandler
                .getInstance().syncExecutor(crearBusUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assertion
        var event =(BusCreado) events.get(0);
        Assertions.assertEquals("Toyota",event.getMarca().value());

    }
}
