package co.com.sofka.pasajero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.pasajero.commands.RegistrarEquipajeCommands;
/**
 * Caso para registrar el equipaje de un pasajero
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class RegistrarEquipajeUseCase extends UseCase<RequestCommand<RegistrarEquipajeCommands>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RegistrarEquipajeCommands> registrarEquipajeCommandsRequestCommand) {
        var command = registrarEquipajeCommandsRequestCommand.getCommand();
        var pasajero =  Pasajero.from(command.getIdPasajero(),retrieveEvents(command.getIdPasajero().value()));
        pasajero.RegistrarEquipaje(command.getIdEquipaje(),command.getPeso(),command.getDescripcion());
        emit().onResponse(new ResponseEvents(pasajero.getUncommittedChanges()));
    }
}
