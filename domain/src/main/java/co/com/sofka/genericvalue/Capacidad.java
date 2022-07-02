package co.com.sofka.genericvalue;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * Objeto de valor tipo Integer para capacidad
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Capacidad implements ValueObject<Integer> {
    private final Integer value;

    public Capacidad(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value < 10){
            throw new IllegalArgumentException("No se permiten valores menores a 10 kilometros");
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
        Capacidad capacidad = (Capacidad) o;
        return Objects.equals(value, capacidad.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
