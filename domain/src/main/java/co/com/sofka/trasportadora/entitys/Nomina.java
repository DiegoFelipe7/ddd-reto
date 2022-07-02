package co.com.sofka.trasportadora.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import co.com.sofka.pasajero.values.Fecha;
import co.com.sofka.trasportadora.values.Colaboradores;
import co.com.sofka.trasportadora.values.IdNomina;
import co.com.sofka.trasportadora.values.Monto;
/**
 * Entity Nomina
 *
 * @author Diego Felipe Muñoz <diegofelipem99@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Nomina extends Entity<IdNomina> {
    private Colaboradores colaboradores;
    private Fecha fecha;
    private Monto monto;

    public Nomina(IdNomina idNomina, Colaboradores colaboradores,Fecha fecha, Monto monto) {
        super(idNomina);
        this.colaboradores = colaboradores;
        this.fecha=fecha;
        this.monto = monto;
    }

    public Colaboradores getColaboradores() {
        return colaboradores;
    }

    public Monto getMonto() {
        return monto;
    }

    public void PagoDeNomina(Monto monto){
        this.monto=monto;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
