package co.com.sofka.pasajero.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * Objeto de valor tipo String para Descripcion
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Descripcion implements ValueObject<String> {
    private final String value;

    public Descripcion(String value) {
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
        Descripcion descripcion = (Descripcion) o;
        return Objects.equals(value, descripcion.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
