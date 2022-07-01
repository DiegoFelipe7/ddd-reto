package co.com.sofka.trasportadora.values;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.pasajero.values.Peso;

import java.util.Objects;

public class Colaboradores implements ValueObject<Integer> {
    private final Integer value;

    public Colaboradores(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value < 0){
            throw new IllegalArgumentException("No se permiten valores vacios");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colaboradores colaboradores = (Colaboradores) o;
        return Objects.equals(value, colaboradores.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
