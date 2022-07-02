package co.com.sofka.trasportadora;

import co.com.sofka.bus.values.IdBus;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.values.Descripcion;
import co.com.sofka.pasajero.values.Fecha;
import co.com.sofka.trasportadora.commands.CrearNuevaCedeCommands;
import co.com.sofka.trasportadora.entitys.Cedes;
import co.com.sofka.trasportadora.entitys.Contratacion;
import co.com.sofka.trasportadora.entitys.Nomina;
import co.com.sofka.trasportadora.events.CedeNuevaCreada;
import co.com.sofka.trasportadora.events.TrasportadoraCreada;
import co.com.sofka.trasportadora.values.*;
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
 * Test para crear una nueva cede
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */

public class CrearNuevaCedeCommandsUseCaseTest {
    private NuevaCedeUseCase nuevaCedeUseCase;
    private DomainEventRepository repository;
    @Before
    public void setUp(){
        nuevaCedeUseCase = new NuevaCedeUseCase();
        repository= Mockito.mock(DomainEventRepository.class);
        nuevaCedeUseCase.addRepository(repository);
    }
    @Test
    public void CrearNuevaCede(){
        IdTrasportadora idTrasportadora = new IdTrasportadora("1");
        IdCede idCede = new IdCede("1");
        Nombre nombre = new Nombre("Comotoristas");
        Ubicacion ubicacion = new Ubicacion("Medellin");
        var command = new CrearNuevaCedeCommands(idTrasportadora,idCede,nombre,ubicacion);
        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventNuevaCede());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("10")
                .syncExecutor(nuevaCedeUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        CedeNuevaCreada CedeNuevaCreadaTest= (CedeNuevaCreada) events.get(0);
        Assertions.assertEquals("Comotoristas",CedeNuevaCreadaTest.getNombre().value());


    }
    public List<DomainEvent> eventNuevaCede(){
        Set<IdBus> busSet = new HashSet<>();
        Set<Contratacion> contratacionSet = new HashSet<>();
        Set<Cedes> cedesSet = new HashSet<>();
        IdTrasportadora idTrasportadora = new IdTrasportadora("1");
        Nit nit = new Nit(1450);
        Nombre nombre = new Nombre("InterRapidisimo");
        busSet.add(IdBus.of("1"));
        Nomina nomina = new Nomina(IdNomina.of("1"),new Colaboradores(50),new Fecha(LocalDate.now()),new Monto(12.500000));
        contratacionSet.add(new Contratacion(IdContratacion.of("1"),new Años(2),new Monto(1.500000),
                new Motivo("Compra documentos") , new Descripcion("Compra de papeleria")));
        cedesSet.add(new Cedes(IdCede.of("1"),new Nombre("Comotoristas"),new Ubicacion("Valle del cauca")));
        return List.of(new TrasportadoraCreada(nit,nombre,busSet,nomina,contratacionSet,cedesSet));
    }
}
