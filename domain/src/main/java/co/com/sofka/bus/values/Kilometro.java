package co.com.sofka.bus.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * Objeto de valor tipo Integer para kilometros de un destino
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Kilometro implements ValueObject<Integer> {
    private final Integer value;

    public Kilometro(Integer value) {
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
        Kilometro kilometro = (Kilometro) o;
        return Objects.equals(value, kilometro.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
