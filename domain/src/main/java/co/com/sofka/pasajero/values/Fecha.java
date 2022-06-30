package co.com.sofka.pasajero.values;
import java.time.LocalDate;
import java.util.Objects;

public class Fecha {
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


}
