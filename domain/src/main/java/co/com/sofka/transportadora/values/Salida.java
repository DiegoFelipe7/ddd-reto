package co.com.sofka.transportadora.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Salida implements ValueObject<String> {
    private final String lugar_salida;

    public Salida(String lugar_salida){
        this.lugar_salida= Objects.requireNonNull(lugar_salida);
        if(this.lugar_salida.isEmpty()){
            throw  new IllegalArgumentException("No se permiten valores vacios");
        }
    }

    @Override
    public String value() {
        return lugar_salida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salida salida = (Salida) o;
        return Objects.equals(lugar_salida, salida.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lugar_salida);
    }




}
