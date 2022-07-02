package co.com.sofka.pasajero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.pasajero.commands.ComprarTicketCommands;

/**
 * Caso para realizar la compra de un ticket
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class ComprarTicketUseCase extends UseCase<RequestCommand<ComprarTicketCommands>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ComprarTicketCommands> comprarTicketRequestCommand) {
        var command = comprarTicketRequestCommand.getCommand();
        var pasajero = Pasajero.from(command.getIdPasajero(),retrieveEvents(command.getIdPasajero().value()));
        pasajero.ComprarTicket(command.getIdTicket(),command.getPrecio(),command.getDestino(),command.getFecha(),command.getEstado());
        emit().onResponse(new ResponseEvents(pasajero.getUncommittedChanges()));
    }
}
