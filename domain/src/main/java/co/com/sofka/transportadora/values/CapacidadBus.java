package co.com.sofka.transportadora.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CapacidadBus implements ValueObject<Integer> {
    private final Integer capacidad_bus;

    public CapacidadBus(Integer capacidad_bus) {
        this.capacidad_bus = Objects.requireNonNull(capacidad_bus);
        if(capacidad_bus<4){
            throw new IllegalArgumentException("No se permiten valores menores a 4 puestos");
        }
    }


    @Override
    public Integer value() {
        return capacidad_bus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CapacidadBus capacidadBus = (CapacidadBus) o;
        return Objects.equals(capacidad_bus, capacidadBus.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacidad_bus);
    }

}
