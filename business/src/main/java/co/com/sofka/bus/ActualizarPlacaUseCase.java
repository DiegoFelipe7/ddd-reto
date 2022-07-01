package co.com.sofka.bus;

import co.com.sofka.bus.commands.ActualizacionPlaca;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarPlacaUseCase extends UseCase<RequestCommand<ActualizacionPlaca>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizacionPlaca> actualizacionPlacaRequestCommand) {
        var command = actualizacionPlacaRequestCommand.getCommand();
        var bus =  Bus.from(command.getIdBus(),retrieveEvents(command.getIdBus().value()));
        if(command.getPlaca().equals("")){
            throw new IllegalArgumentException("No se permiten vacios");
        }
        bus.ActualizarPlaca(command.getPlaca());
        emit().onResponse(new ResponseEvents(bus.getUncommittedChanges()));

    }
}
