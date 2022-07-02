package co.com.sofka.genericvalue;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * Objeto de valor tipo String para nombre
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Nombre implements ValueObject<String> {
    private String nombre;

    public Nombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String value() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre_ = (Nombre) o;
        return Objects.equals(nombre, nombre_.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

}
