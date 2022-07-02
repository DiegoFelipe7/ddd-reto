package co.com.sofka.bus.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.pasajero.values.IdTicket;
/**
 * Objeto de valor tipo Identy para id de una bus
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class IdBus extends Identity {

    public IdBus(String uuid){
        super(uuid);
    }

    public static IdBus of(String uuid){
        return new IdBus(uuid);
    }
}
