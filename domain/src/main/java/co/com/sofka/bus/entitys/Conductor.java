package co.com.sofka.bus.entitys;

import co.com.sofka.bus.values.IdConductor;
import co.com.sofka.bus.values.Licencia;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.genericvalue.Identificacion;
import co.com.sofka.genericvalue.Nombre;
/**
 * Entity Constructor
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Conductor extends Entity<IdConductor> {
    private Nombre nombre;
    private Licencia licencia;
    private Identificacion identificacion;

    public Conductor(IdConductor idConductor, Nombre nombre, Licencia licencia, Identificacion identificacion) {
        super(idConductor);
        this.nombre = nombre;
        this.licencia = licencia;
        this.identificacion = identificacion;
    }

    public void actualizarLicencia(Licencia licencia){
        this.licencia=licencia;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Licencia getLicencia() {
        return licencia;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }
}
