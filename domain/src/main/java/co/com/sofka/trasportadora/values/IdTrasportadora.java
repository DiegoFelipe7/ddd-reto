package co.com.sofka.trasportadora.values;

import co.com.sofka.domain.generic.Identity;

public class IdTrasportadora extends Identity {

    public IdTrasportadora(String uuid){
        super(uuid);
    }

    public static IdTrasportadora of(String uuid){
        return new IdTrasportadora(uuid);
    }
}
