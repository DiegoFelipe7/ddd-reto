package co.com.sofka.pasajero.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.genericvalues.Estado;
import co.com.sofka.genericvalues.Identificacion;
import co.com.sofka.pasajero.values.IdAsiento;

public class Asiento extends Entity<IdAsiento> {
    private Identificacion identificacion;
    private Estado estado;

    public Asiento(IdAsiento idAsiento , Identificacion identificacion , Estado estado){
        super(idAsiento);
        this.identificacion=identificacion;
        this.estado=estado;
    }

    public void  CambiarEstado(Estado estado){
        this.estado=estado;
    }
}
