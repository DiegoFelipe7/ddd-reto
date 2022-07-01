package co.com.sofka.pasajero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.pasajero.commands.ActualizarIdentificacion;

public class ActualizarIdentificacionUseCase extends UseCase<RequestCommand<ActualizarIdentificacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarIdentificacion> actualizarIdentificacionRequestCommand) {
        var command = actualizarIdentificacionRequestCommand.getCommand();
        var pasajero = Pasajero.from(command.getIdPasajero(),retrieveEvents(command.getIdPasajero().value()));
        if(command.getIdentificacion().equals("")){
            throw new IllegalArgumentException("No se permiten vacios");
        }
        pasajero.ActualizarIdentificacion(command.getIdentificacion());
        emit().onResponse(new ResponseEvents(pasajero.getUncommittedChanges()));
    }
}
