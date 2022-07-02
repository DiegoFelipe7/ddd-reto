package co.com.sofka.pasajero.values;
import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;
/**
 * Objeto de valor tipo LocalDate para Placa
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Fecha implements ValueObject<LocalDate> {
    private final LocalDate value;

    public Fecha(LocalDate value) {
        this.value = LocalDate.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fecha fecha = (Fecha) o;
        return Objects.equals(value, fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


    @Override
    public LocalDate value() {
        return value;
    }
}
