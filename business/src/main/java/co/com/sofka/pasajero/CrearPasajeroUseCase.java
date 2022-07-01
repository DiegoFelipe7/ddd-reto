package co.com.sofka.pasajero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.pasajero.commands.CrearPasajeroCommands;


public class CrearPasajeroUseCase extends UseCase<RequestCommand<CrearPasajeroCommands>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearPasajeroCommands> crearPasajeroRequestCommand) {
        var command = crearPasajeroRequestCommand.getCommand();
        var pasajero = new Pasajero(command.getIdPasajero(),command.getNombre(),command.getIdentificacion(),command.getTicket()
        ,command.getEquipaje(),command.getAsiento());
        emit().onResponse(new ResponseEvents(pasajero.getUncommittedChanges()));
    }
}
