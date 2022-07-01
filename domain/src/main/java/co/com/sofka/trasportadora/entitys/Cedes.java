package co.com.sofka.trasportadora.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.trasportadora.values.IdCede;
import co.com.sofka.trasportadora.values.Ubicacion;

public class Cedes extends Entity<IdCede> {
    private Nombre nombre;
    private  Ubicacion ubicacion;

    public Cedes(IdCede idCede, Nombre nombre, Ubicacion ubicacion) {
        super(idCede);
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void actualizarNombre(Nombre nombre){
        this.nombre=nombre;
    }
}
