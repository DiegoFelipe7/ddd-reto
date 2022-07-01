package co.com.sofka.bus;

import co.com.sofka.bus.commands.AgregarRuta;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarRutaUseCase extends UseCase<RequestCommand<AgregarRuta> , ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarRuta> agregarRutaRequestCommand) {
        var command = agregarRutaRequestCommand.getCommand();
        var bus = Bus.from(command.getIdBus() , retrieveEvents(command.getIdRuta().value()));
        bus.agregarRuta(command.getIdRuta(),command.getSalida(),command.getDestino(),command.getKilometro());
        emit().onResponse(new ResponseEvents(bus.getUncommittedChanges()));
    }
}
