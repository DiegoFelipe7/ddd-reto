package co.com.sofka.pasajero.values;

import co.com.sofka.domain.generic.Identity;
/**
 * Objeto de valor tipo Integer para id de un asiento
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class IdAsiento extends Identity {
    public IdAsiento(String uuid){
        super(uuid);
    }

    public static IdAsiento of(String uuid){
        return new IdAsiento(uuid);
    }
}
