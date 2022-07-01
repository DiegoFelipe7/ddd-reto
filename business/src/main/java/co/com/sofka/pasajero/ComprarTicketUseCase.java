package co.com.sofka.pasajero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.pasajero.commands.ComprarTicketCommands;

public class ComprarTicketUseCase extends UseCase<RequestCommand<ComprarTicketCommands>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ComprarTicketCommands> comprarTicketRequestCommand) {
        var command = comprarTicketRequestCommand.getCommand();
        var pasajero = Pasajero.from(command.getIdPasajero(),retrieveEvents(command.getIdPasajero().value()));
        pasajero.ComprarTicket(command.getIdTicket(),command.getPrecio(),command.getDestino(),command.getFecha(),command.getEstado());
        emit().onResponse(new ResponseEvents(pasajero.getUncommittedChanges()));
    }
}
