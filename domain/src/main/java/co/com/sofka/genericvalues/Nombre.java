package co.com.sofka.genericvalues;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.transportadora.values.Nit;

import java.util.Objects;

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
