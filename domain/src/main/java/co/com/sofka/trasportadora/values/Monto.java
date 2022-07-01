package co.com.sofka.trasportadora.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Monto implements ValueObject<Double> {
    private final Double value;

    public Monto(Double value) {
        this.value = Objects.requireNonNull(value);
        if(this.value<0){
            throw new IllegalArgumentException("No se permiten valores menores a 0");
        }
    }

    @Override
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monto monto = (Monto) o;
        return Objects.equals(value, monto.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}
