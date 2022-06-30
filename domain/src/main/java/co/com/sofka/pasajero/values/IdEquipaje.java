package co.com.sofka.pasajero.values;

import co.com.sofka.domain.generic.Identity;

public class IdEquipaje extends Identity {
    public IdEquipaje(String uuid){
        super(uuid);
    }

    public static IdEquipaje of(String uuid){
        return new IdEquipaje(uuid);
    }
}
