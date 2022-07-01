package co.com.sofka.bus.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.pasajero.values.IdTicket;

public class IdBus extends Identity {

    public IdBus(String uuid){
        super(uuid);
    }

    public static IdBus of(String uuid){
        return new IdBus(uuid);
    }
}
