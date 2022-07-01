package co.com.sofka.trasportadora.values;

import co.com.sofka.domain.generic.Identity;

public class IdContratacion extends Identity {
    public IdContratacion(String uuid){
        super(uuid);
    }

    public static IdContratacion of(String uuid){
        return new IdContratacion(uuid);
    }
}
