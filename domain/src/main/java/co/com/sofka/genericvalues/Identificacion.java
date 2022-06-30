package co.com.sofka.genericvalues;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Identificacion  implements ValueObject<Integer> {
    private final Integer value;

    public Identificacion(Integer value) {
        this.value = Objects.requireNonNull(value);
        if( this.value>1||this.value <30){
            throw new IllegalArgumentException("Esta identicacion de puesto no existe");
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
        Identificacion identificacion = (Identificacion) o;
        return Objects.equals(value, identificacion.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
