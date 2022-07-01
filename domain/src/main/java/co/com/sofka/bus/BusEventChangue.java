package co.com.sofka.bus;

import co.com.sofka.bus.events.BusCreado;
import co.com.sofka.domain.generic.EventChange;

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

    }
}
