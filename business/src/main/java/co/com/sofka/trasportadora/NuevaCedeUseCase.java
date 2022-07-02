package co.com.sofka.trasportadora;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.trasportadora.commands.CrearNuevaCedeCommands;
/**
 * Caso para registrar una nueva cede de una empresa
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class NuevaCedeUseCase extends UseCase<RequestCommand<CrearNuevaCedeCommands>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearNuevaCedeCommands> cedeNuevaCreadaRequestCommand) {
        var command = cedeNuevaCreadaRequestCommand.getCommand();
        var trasportadora = Trasportadora.from(command.getIdTrasportadora(),retrieveEvents(command.getIdTrasportadora().value()));
        trasportadora.crearNuevaCede(command.getIdCede(),command.getNombre(),command.getUbicacion());
        emit().onResponse(new ResponseEvents(trasportadora.getUncommittedChanges()));

    }
}
