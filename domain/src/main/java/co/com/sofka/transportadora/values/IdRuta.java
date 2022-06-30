package co.com.sofka.transportadora.values;

import co.com.sofka.domain.generic.Identity;

public class IdRuta extends Identity {
    public IdRuta(String uuid){
        super(uuid);
    }

    public static  IdRuta of(String uuid){
        return new IdRuta(uuid);
    }
}
