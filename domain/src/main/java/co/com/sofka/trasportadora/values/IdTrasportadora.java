package co.com.sofka.trasportadora.values;

import co.com.sofka.domain.generic.Identity;
/**
 * Objeto de valor tipo Integer id para la trasportadora
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class IdTrasportadora extends Identity {

    public IdTrasportadora(String uuid){
        super(uuid);
    }

    public static IdTrasportadora of(String uuid){
        return new IdTrasportadora(uuid);
    }
}
