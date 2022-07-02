package co.com.sofka.trasportadora;

import co.com.sofka.bus.values.IdBus;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.pasajero.values.Descripcion;
import co.com.sofka.pasajero.values.Fecha;
import co.com.sofka.trasportadora.commands.CrearTrasportadora;
import co.com.sofka.trasportadora.entitys.Cedes;
import co.com.sofka.trasportadora.entitys.Contratacion;
import co.com.sofka.trasportadora.entitys.Nomina;
import co.com.sofka.trasportadora.events.TrasportadoraCreada;
import co.com.sofka.trasportadora.values.*;
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
 * Test para crear una empresa de trasporte
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
public class CrearTrasportadorUseCaseTest {
    @InjectMocks
    private CrearTrasportadorUseCase crearTrasportadorUseCase;

    @Mock
    DomainEventRepository repository;

    @Test
    public void CrearTrasportadora(){
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

        var command = new CrearTrasportadora(idTrasportadora,nit,nombre,busSet,nomina,contratacionSet,cedesSet);

        var events = UseCaseHandler
                .getInstance().syncExecutor(crearTrasportadorUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assertion
        var event =(TrasportadoraCreada) events.get(0);
        Assertions.assertEquals("InterRapidisimo",event.getNombre().value());
        Assertions.assertEquals(1450,event.getNit().value());

    }
}
