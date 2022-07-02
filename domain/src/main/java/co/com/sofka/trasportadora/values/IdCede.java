package co.com.sofka.trasportadora.values;

import co.com.sofka.domain.generic.Identity;
/**
 * Objeto de valor tipo Integer id de una cede
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class IdCede extends Identity {
    public IdCede(String uuid){
        super(uuid);
    }

    public static IdCede of(String uuid){
        return new IdCede(uuid);
    }
}
