package co.com.sofka.bus;

import co.com.sofka.bus.commands.ActualizacionPlacaCommands;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarPlacaUseCase extends UseCase<RequestCommand<ActualizacionPlacaCommands>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizacionPlacaCommands> actualizacionPlacaRequestCommand) {
        var command = actualizacionPlacaRequestCommand.getCommand();
        var bus =  Bus.from(command.getIdBus(),retrieveEvents(command.getIdBus().value()));

        bus.ActualizarPlaca(command.getPlaca());
        emit().onResponse(new ResponseEvents(bus.getUncommittedChanges()));

    }
}
