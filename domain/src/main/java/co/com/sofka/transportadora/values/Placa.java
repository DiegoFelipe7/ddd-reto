package co.com.sofka.transportadora.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Placa implements ValueObject<String> {
    private final String placa_bus;

    public Placa(String placa_bus) {
        this.placa_bus = Objects.requireNonNull(placa_bus);
        if(this.placa_bus.isEmpty()){
            throw new IllegalArgumentException("No se permiten valores vacios");
        }
    }

    @Override
    public String value() {
        return placa_bus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Placa placa = (Placa) o;
        return Objects.equals(placa_bus, placa.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa_bus);
    }


}
