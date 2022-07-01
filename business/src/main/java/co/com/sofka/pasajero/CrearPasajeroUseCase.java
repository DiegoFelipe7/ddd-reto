package co.com.sofka.pasajero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.pasajero.commands.CrearPasajero;


public class CrearPasajeroUseCase extends UseCase<RequestCommand<CrearPasajero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearPasajero> crearPasajeroRequestCommand) {
        var command = crearPasajeroRequestCommand.getCommand();
        var pasajero = new Pasajero(command.getIdPasajero(),command.getNombre(),command.getIdentificacion(),command.getIdAsiento());
        emit().onResponse(new ResponseEvents(pasajero.getUncommittedChanges()));
    }
}
