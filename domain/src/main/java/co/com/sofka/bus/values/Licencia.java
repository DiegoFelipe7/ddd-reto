package co.com.sofka.bus.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de valor tipo Integer para kilometros
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Licencia implements ValueObject<String> {
    private final String value;

    public Licencia(String value) {
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
        Licencia licencia = (Licencia) o;
        return Objects.equals(value, licencia.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
