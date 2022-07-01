package co.com.sofka.trasportadora;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.trasportadora.entitys.Cedes;
import co.com.sofka.trasportadora.events.BusContratado;
import co.com.sofka.trasportadora.events.CedeNuevaCreada;
import co.com.sofka.trasportadora.events.NitModificado;
import co.com.sofka.trasportadora.events.TrasportadoraCreada;

import java.util.HashSet;

public class TrasportadoraEventChangue extends EventChange {
    public TrasportadoraEventChangue(Trasportadora trasportadora){
        apply((TrasportadoraCreada event)->{
            trasportadora.nit=event.getNit();
            trasportadora.nombre=event.getNombre();
            trasportadora.idBuses=event.getBusSet();
            trasportadora.nomina=event.getNomina();
            trasportadora.contratacionSet=event.getContratacionSet();
            trasportadora.cedesSet=event.getCedesSet();
        });

        apply((BusContratado event)->{
            trasportadora.idBuses.add(event.getIdBus());
        });

        apply((CedeNuevaCreada event)->{
            trasportadora.cedesSet.add(new Cedes(event.getIdCede(),event.getNombre(),event.getUbicacion()));
        });
        apply((NitModificado event)->{
            trasportadora.nit=event.getNit();
        });
    }
}
