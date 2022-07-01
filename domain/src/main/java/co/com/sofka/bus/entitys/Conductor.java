package co.com.sofka.bus.entitys;

import co.com.sofka.bus.values.IdConductor;
import co.com.sofka.bus.values.Licencia;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.genericvalues.Identificacion;
import co.com.sofka.genericvalues.Nombre;

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
