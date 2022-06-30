package co.com.sofka.pasajero.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.pasajero.values.Descripcion;
import co.com.sofka.pasajero.values.IdEquipaje;
import co.com.sofka.pasajero.values.Peso;

import java.util.Objects;

public class Equipaje extends Entity<IdEquipaje> {
    private Peso peso;
    private Descripcion descripcion;

    public Equipaje(IdEquipaje entityId, Peso peso, Descripcion descripcion) {
        super(entityId);
        this.peso = peso;
        this.descripcion = descripcion;
    }

    public void RegistrarDescripcion(Descripcion descripcion){
        this.descripcion= descripcion;
    }


    public void ActualizarPeso(Peso peso_equipaje){
        this.peso= peso_equipaje;
    }
}
