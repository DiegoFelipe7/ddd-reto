package co.com.sofka.trasportadora.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * Objeto de valor tipo Integer para el nit
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Nit implements ValueObject<Integer> {
    private final Integer value;

    public Nit(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value<0){
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
        Nit nit = (Nit) o;
        return Objects.equals(value, nit.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}
