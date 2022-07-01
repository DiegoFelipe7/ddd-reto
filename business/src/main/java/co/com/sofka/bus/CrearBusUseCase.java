package co.com.sofka.bus;

import co.com.sofka.bus.commands.CrearBus;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearBusUseCase extends UseCase<RequestCommand<CrearBus>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearBus> crearBusRequestCommand) {
        var command = crearBusRequestCommand.getCommand();
        var bus = new Bus(command.getIdBus(),command.getMarca(),command.getPlaca(),
                command.getCapacidad() , command.getIdPasajero() , command.getRutaSet() , command.getConductor(),command.getBodega());
        emit().onResponse(new ResponseEvents(bus.getUncommittedChanges()));
    }
}
