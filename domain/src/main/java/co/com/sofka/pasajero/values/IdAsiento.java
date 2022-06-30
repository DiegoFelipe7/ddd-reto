package co.com.sofka.pasajero.values;

import co.com.sofka.domain.generic.Identity;

public class IdAsiento extends Identity {
    public IdAsiento(String uuid){
        super(uuid);
    }

    public static IdAsiento of(String uuid){
        return new IdAsiento(uuid);
    }
}
