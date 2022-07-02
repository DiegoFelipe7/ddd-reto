package co.com.sofka.bus.events;

import co.com.sofka.bus.values.Destino;
import co.com.sofka.bus.values.IdRuta;
import co.com.sofka.bus.values.Kilometro;
import co.com.sofka.bus.values.Salida;
import co.com.sofka.domain.generic.DomainEvent;
/**
 * DomainEvent RutasAgregadas
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class RutasAgregadas extends DomainEvent {
    private final IdRuta idRuta;
    private final Salida salida;
    private final Destino destino;
    private final Kilometro kilometro;

    public RutasAgregadas( IdRuta idRuta, Salida salida, Destino destino, Kilometro kilometro) {
        super("sofka.bus.event.RutasAgregadas");
        this.idRuta=idRuta;
        this.salida = salida;
        this.destino = destino;
        this.kilometro = kilometro;
    }

    public IdRuta getIdRuta() {
        return idRuta;
    }

    public Salida getSalida() {
        return salida;
    }

    public Destino getDestino() {
        return destino;
    }

    public Kilometro getKilometro() {
        return kilometro;
    }
}
