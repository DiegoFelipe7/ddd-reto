package co.com.sofka.pasajero.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Peso implements ValueObject<Integer> {
    private final Integer value;

    public Peso(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(value <0){
            throw new IllegalArgumentException("No se permiten valores menores a 0");
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
        Peso peso = (Peso) o;
        return Objects.equals(value, peso.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}
