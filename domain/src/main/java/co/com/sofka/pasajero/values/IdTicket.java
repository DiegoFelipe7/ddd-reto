package co.com.sofka.pasajero.values;

import co.com.sofka.domain.generic.Identity;

public class IdTicket extends Identity {
    public IdTicket(String uuid){
        super(uuid);
    }

    public static IdTicket of(String uuid){
        return new IdTicket(uuid);
    }
}
