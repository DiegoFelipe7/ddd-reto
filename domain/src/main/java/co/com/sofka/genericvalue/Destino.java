package co.com.sofka.genericvalue;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * Objeto de valor tipo String para destino
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Destino implements ValueObject<String> {
    private final String lugar_destino;

    public Destino(String lugar_destino) {
        this.lugar_destino = Objects.requireNonNull(lugar_destino);
        if(this.lugar_destino.isEmpty()){
            throw new IllegalArgumentException("No se permiten valores vacios");

        }
    }


    @Override
    public String value() {
        return lugar_destino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destino destino = (Destino) o;
        return Objects.equals(lugar_destino, destino.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lugar_destino);
    }


}
