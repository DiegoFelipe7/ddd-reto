package co.com.sofka.pasajero.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * Objeto de valor tipo Double para precio
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Precio implements ValueObject<Double> {
    private final Double value;

    public Precio(Double value) {

        this.value = Objects.requireNonNull(value);
        if(this.value <0){
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
        Precio precio = (Precio) o;
        return Objects.equals(value, precio.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}
