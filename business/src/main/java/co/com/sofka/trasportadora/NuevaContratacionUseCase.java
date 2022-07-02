package co.com.sofka.trasportadora;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.trasportadora.commands.NuevaContratacion;

/**
 * Caso para las contrataciones de la trasportadora
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class NuevaContratacionUseCase extends UseCase<RequestCommand<NuevaContratacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<NuevaContratacion> nuevaContratacionRequestCommand) {
        var command = nuevaContratacionRequestCommand.getCommand();
        var trasportadora = Trasportadora.from(command.getIdTrasportadora(),retrieveEvents(command.getIdTrasportadora().value()));
        trasportadora.NuevaContratacion(command.getIdContratacion(),command.getAños(),command.getMonto(),command.getMotivo()
        ,command.getDescripcion());
        emit().onResponse(new ResponseEvents(trasportadora.getUncommittedChanges()));
    }
}