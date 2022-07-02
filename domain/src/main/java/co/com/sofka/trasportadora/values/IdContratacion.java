package co.com.sofka.trasportadora.values;

import co.com.sofka.domain.generic.Identity;
/**
 * Objeto de valor tipo Integer id de una contratacion
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class IdContratacion extends Identity {
    public IdContratacion(String uuid){
        super(uuid);
    }

    public static IdContratacion of(String uuid){
        return new IdContratacion(uuid);
    }
}
