package co.com.sofka.trasportadora;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.trasportadora.commands.ModificarNitCommands;
/**
 * Caso para modificar el nit de una empresa
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class ModificarNitUseCase extends UseCase<RequestCommand<ModificarNitCommands>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarNitCommands> modificarNitCommandsRequestCommand) {
        var command = modificarNitCommandsRequestCommand.getCommand();
        var trasportador = Trasportadora.from(command.getIdTrasportadora(),retrieveEvents(command.getIdTrasportadora().value()));
        trasportador.ModificarNit(command.getNit());
        emit().onResponse(new ResponseEvents(trasportador.getUncommittedChanges()));
    }
}
