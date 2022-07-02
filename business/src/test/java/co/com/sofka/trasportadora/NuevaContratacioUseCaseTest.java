package co.com.sofka.trasportadora;

import co.com.sofka.bus.values.IdBus;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.values.Descripcion;
import co.com.sofka.pasajero.values.Fecha;
import co.com.sofka.trasportadora.commands.NuevaContratacion;
import co.com.sofka.trasportadora.entitys.Cedes;
import co.com.sofka.trasportadora.entitys.Contratacion;
import co.com.sofka.trasportadora.entitys.Nomina;
import co.com.sofka.trasportadora.events.ContratacionRealizada;
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
 * Test para nueva contratacion
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */

public class NuevaContratacioUseCaseTest {
    private NuevaContratacionUseCase nuevaContratacionUseCase;
    DomainEventRepository repository;

    @Before
    public void setUp(){
        nuevaContratacionUseCase = new NuevaContratacionUseCase();
        repository= Mockito.mock(DomainEventRepository.class);
        nuevaContratacionUseCase.addRepository(repository);
    }
    @Test
    public void CrearNuevoContrato(){
        IdTrasportadora idTrasportadora = new IdTrasportadora("1");
        IdContratacion idContratacion = new IdContratacion("1");
        Años años = new Años(2);
        Monto monto = new Monto(1.2500);
        Motivo motivo = new Motivo("Taller Mecanico");
        Descripcion descripcion = new Descripcion("Contratar taller para mantenimineo de buses");
        var command = new NuevaContratacion(idTrasportadora,idContratacion,años,monto,motivo,descripcion);
        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventsNuevoContrato());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(nuevaContratacionUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        ContratacionRealizada contratacionRealizadaTest= (ContratacionRealizada) events.get(0);
        Assertions.assertEquals("Taller Mecanico",contratacionRealizadaTest.getMotivo().value());

    }

    public List<DomainEvent> eventsNuevoContrato (){
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
