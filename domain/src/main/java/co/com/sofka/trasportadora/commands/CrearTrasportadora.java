package co.com.sofka.trasportadora.commands;

import co.com.sofka.bus.values.IdBus;
import co.com.sofka.genericvalue.Nombre;
import co.com.sofka.trasportadora.entitys.Cedes;
import co.com.sofka.trasportadora.entitys.Contratacion;
import co.com.sofka.trasportadora.entitys.Nomina;
import co.com.sofka.trasportadora.values.IdTrasportadora;
import co.com.sofka.trasportadora.values.Nit;

import java.util.Set;

public class CrearTrasportadora {
    private final IdTrasportadora idTrasportadora;
    private final Nit nit;
    private final Nombre nombre;
    private final Set<IdBus> idBuses;
    private final Nomina nomina;
    private final Set<Contratacion> contratacionSet;
    private final Set<Cedes> cedesSet;

    public CrearTrasportadora(IdTrasportadora idTrasportadora, Nit nit, Nombre nombre, Set<IdBus> idBuses, Nomina nomina, Set<Contratacion> contratacionSet, Set<Cedes> cedesSet) {
        this.idTrasportadora = idTrasportadora;
        this.nit = nit;
        this.nombre = nombre;
        this.idBuses = idBuses;
        this.nomina = nomina;
        this.contratacionSet = contratacionSet;
        this.cedesSet = cedesSet;
    }

    public IdTrasportadora getIdTrasportadora() {
        return idTrasportadora;
    }

    public Nit getNit() {
        return nit;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Set<IdBus> getIdBuses() {
        return idBuses;
    }

    public Nomina getNomina() {
        return nomina;
    }

    public Set<Contratacion> getContratacionSet() {
        return contratacionSet;
    }

    public Set<Cedes> getCedesSet() {
        return cedesSet;
    }
}
