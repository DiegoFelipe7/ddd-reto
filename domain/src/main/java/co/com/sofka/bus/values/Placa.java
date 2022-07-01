package co.com.sofka.bus.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Placa implements ValueObject<String> {
    private final String value;

    public Placa(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isEmpty()){
            throw new IllegalArgumentException("No se permiten valores vacios");
        }
    }

    @Override
    public String value() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Placa placa = (Placa) o;
        return Objects.equals(value, placa.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
