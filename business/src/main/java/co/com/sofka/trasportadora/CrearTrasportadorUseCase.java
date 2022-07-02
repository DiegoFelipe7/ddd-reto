package co.com.sofka.trasportadora;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.trasportadora.commands.CrearTrasportadora;
/**
 * Caso para crear una empresa de trasporte
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class CrearTrasportadorUseCase extends UseCase<RequestCommand<CrearTrasportadora>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearTrasportadora> crearTrasportadoraRequestCommand) {
        var command = crearTrasportadoraRequestCommand.getCommand();
        var trasportadora = new Trasportadora(command.getIdTrasportadora(),command.getNit(),command.getNombre(),command.getIdBuses(),command.getNomina(),command.getContratacionSet(),command.getCedesSet());
        emit().onResponse(new ResponseEvents(trasportadora.getUncommittedChanges()));
    }
}
