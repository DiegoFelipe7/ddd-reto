package co.com.sofka.trasportadora.values;

import co.com.sofka.domain.generic.Identity;

public class IdNomina extends Identity {
    public IdNomina(String uuid){
        super(uuid);
    }

    public static IdNomina of(String uuid){
        return new IdNomina(uuid);
    }
}
