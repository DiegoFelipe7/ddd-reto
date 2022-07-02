package co.com.sofka.pasajero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.pasajero.commands.ActualizarIdentificacionCommands;

/**
 * Caso para actualizar la identificacion de un pajajero
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class ActualizarIdentificacionUseCase extends UseCase<RequestCommand<ActualizarIdentificacionCommands>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarIdentificacionCommands> actualizarIdentificacionRequestCommand) {
        var command = actualizarIdentificacionRequestCommand.getCommand();
        var pasajero = Pasajero.from(command.getIdPasajero(),retrieveEvents(command.getIdPasajero().value()));
        if(command.getIdentificacion().equals("")){
            throw new IllegalArgumentException("No se permiten vacios");
        }
        pasajero.ActualizarIdentificacion(command.getIdentificacion());
        emit().onResponse(new ResponseEvents(pasajero.getUncommittedChanges()));
    }
}
