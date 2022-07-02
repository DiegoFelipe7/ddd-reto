package co.com.sofka.trasportadora.values;

import co.com.sofka.domain.generic.Identity;
/**
 * Objeto de valor tipo Integer id de la nomina
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class IdNomina extends Identity {
    public IdNomina(String uuid){
        super(uuid);
    }

    public static IdNomina of(String uuid){
        return new IdNomina(uuid);
    }
}
