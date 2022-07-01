package co.com.sofka.pasajero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.pasajero.commands.CrearPasajero;

public class PasajeroUseCase extends UseCase<RequestCommand<CrearPasajero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearPasajero> crearPasajeroRequestCommand) {

    }
}
