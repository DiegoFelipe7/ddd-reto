package co.com.sofka.bus;

import co.com.sofka.bus.commands.AgregarPasajeroCommands;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarPasajeroUseCase extends UseCase<RequestCommand<AgregarPasajeroCommands>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPasajeroCommands> agregarPasajeroRequestCommand) {
        var command = agregarPasajeroRequestCommand.getCommand();
        var bus = Bus.from(command.getIdBus(),retrieveEvents(command.getIdBus().value()));
        bus.agregarPasajeros(command.getIdPasajero());
        emit().onResponse(new ResponseEvents(bus.getUncommittedChanges()));
    }
}
