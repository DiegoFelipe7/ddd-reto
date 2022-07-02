package co.com.sofka.pasajero.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.pasajero.values.Descripcion;
import co.com.sofka.pasajero.values.IdEquipaje;
import co.com.sofka.pasajero.values.Peso;
/**
 * Entity Equipaje
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Equipaje extends Entity<IdEquipaje> {
    private Peso peso;
    private Descripcion descripcion;

    public Equipaje(IdEquipaje idEquipaje, Peso peso, Descripcion descripcion) {
        super(idEquipaje);
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
