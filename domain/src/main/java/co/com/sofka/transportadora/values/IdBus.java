package co.com.sofka.transportadora.values;

import co.com.sofka.domain.generic.Identity;

public class IdBus extends Identity {
    public IdBus(String uuid){
        super(uuid);
    }

    public static IdBus of(String uuid){
        return new IdBus(uuid);
    }
}
