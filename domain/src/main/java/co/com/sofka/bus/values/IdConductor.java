package co.com.sofka.bus.values;

import co.com.sofka.domain.generic.Identity;

public class IdConductor extends Identity {
    public IdConductor(String uuid){
        super(uuid);
    }

    public static IdConductor of(String uuid){
        return new IdConductor(uuid);
    }
}
