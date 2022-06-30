package co.com.sofka.transportadora.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Kilometro implements ValueObject<Integer> {
    private final Integer kilometro;

    public Kilometro(Integer kilometro) {
        this.kilometro = Objects.requireNonNull(kilometro);
        if(kilometro<0){
            throw new IllegalArgumentException("No se permiten valores negativos");
        }
    }


    @Override
    public Integer value() {
        return kilometro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kilometro kilometr = (Kilometro) o;
        return Objects.equals(kilometro, kilometr.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(kilometro);
    }


}
