package co.com.sofka.bus;

import co.com.sofka.bus.entitys.Ruta;
import co.com.sofka.bus.events.BusCreado;
import co.com.sofka.bus.events.PasajerosAgregados;
import co.com.sofka.bus.events.PlacaActualizada;
import co.com.sofka.bus.events.RutasAgregadas;
import co.com.sofka.domain.generic.EventChange;
/**
 * EvenChangue  Bus para el manejo de enventos
 *
 * @Version 1.0
 * @Author Diego Felipe Muñoz Mosquera
 * @Email diegofelipem99@gmail.com
 * *
 */
public class BusEventChangue extends EventChange {
    public BusEventChangue(Bus bus){
        apply((BusCreado event)->{
            bus.marca=event.getMarca();
            bus.placa=event.getPlaca();
            bus.capacidad=event.getCapacidad();
            bus.idPasajeros=event.getPasajeroSet();
            bus.conductor=event.getConductor();
            bus.bodega=event.getBodega();
        });

        apply((RutasAgregadas events)->{
            bus.rutaSet.add(new Ruta(events.getIdRuta(),events.getSalida(),events.getDestino(),events.getKilometro()));
        });

        apply((PlacaActualizada events)->{
            bus.placa=events.getPlaca();
        });

        apply((PasajerosAgregados events)->{
            bus.idPasajeros.add(events.getIdPasajero());

        });

    }
}
