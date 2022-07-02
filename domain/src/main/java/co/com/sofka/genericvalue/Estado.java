package co.com.sofka.genericvalue;
import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;
/**
 * Objeto de valor tipo boolean para estado
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Estado implements ValueObject<Boolean> {

    private final boolean value;

    public Estado(boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(value, estado.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}

