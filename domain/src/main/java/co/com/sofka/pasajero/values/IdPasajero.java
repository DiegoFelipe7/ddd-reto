package co.com.sofka.pasajero.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.transportadora.values.IdRuta;

public class IdPasajero extends Identity {
    public IdPasajero(String uuid){
        super(uuid);
    }

    public static IdPasajero of(String uuid){
        return new IdPasajero(uuid);
    }
}
