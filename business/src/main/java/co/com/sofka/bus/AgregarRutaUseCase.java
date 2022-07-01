package co.com.sofka.bus;

import co.com.sofka.bus.commands.AgregarRutaCommads;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarRutaUseCase extends UseCase<RequestCommand<AgregarRutaCommads> , ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarRutaCommads> agregarRutaRequestCommand) {
        var command = agregarRutaRequestCommand.getCommand();
        var bus = Bus.from(command.getIdBus() , retrieveEvents(command.getIdRuta().value()));
        bus.agregarRuta(command.getIdRuta(),command.getSalida(),command.getDestino(),command.getKilometro());
        emit().onResponse(new ResponseEvents(bus.getUncommittedChanges()));
    }
}
