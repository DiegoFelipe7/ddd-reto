package co.com.sofka.bus.values;

import co.com.sofka.domain.generic.Identity;
/**
 * Objeto de valor tipo Identy para id de una conductor
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class IdConductor extends Identity {
    public IdConductor(String uuid){
        super(uuid);
    }

    public static IdConductor of(String uuid){
        return new IdConductor(uuid);
    }
}
