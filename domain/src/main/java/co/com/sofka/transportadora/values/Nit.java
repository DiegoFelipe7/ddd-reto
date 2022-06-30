package co.com.sofka.transportadora.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nit implements ValueObject<String> {
    private final String nit_empresa;

    public Nit(String nit_empresa) {
        this.nit_empresa = Objects.requireNonNull(nit_empresa);
        if(this.nit_empresa.isEmpty()){
            throw new IllegalArgumentException("No se permiten valores menores a cero");
        }
    }

    @Override
    public String value() {
        return nit_empresa;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nit nit = (Nit) o;
        return Objects.equals(nit_empresa, nit.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nit_empresa);
    }





}
