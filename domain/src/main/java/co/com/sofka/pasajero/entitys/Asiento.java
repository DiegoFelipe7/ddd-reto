package co.com.sofka.pasajero.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.genericvalue.Estado;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.pasajero.values.IdAsiento;
/**
 * Entity Asiento
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
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

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public Estado getEstado() {
        return estado;
    }
}
