package co.com.sofka.trasportadora.values;

import co.com.sofka.domain.generic.Identity;

public class IdCede extends Identity {
    public IdCede(String uuid){
        super(uuid);
    }

    public static IdCede of(String uuid){
        return new IdCede(uuid);
    }
}
