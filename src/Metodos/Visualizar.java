package Metodos;

import Clases.Cliente;
import Clases.CuentaCorriente;
import Clases.CuentaPlazo;
import Clases.Movimiento;
import java.io.BufferedReader;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

/**
 *
 * @author a16alfonsofa
 */
public class Visualizar {

    public static void Clientes(BufferedReader leer) {
        ODB odb = ODBFactory.openClient("localhost", 8000, "Cuentas");

        Values val = odb.getValues(new ValuesCriteriaQuery(Cliente.class)
                .field("dni")
                .field("nombre")
                .field("direccion"));

        while (val.hasNext()) {
            ObjectValues ov = (ObjectValues) val.next();

            System.out.println("Nombre: " + ov.getByAlias("nombre")
                    + "\n DNI: " + ov.getByAlias("dni")
                    + "\n DIRECCION: " + ov.getByAlias("direccion"));
        }
        odb.close();
    }

    public static void CuentasC(BufferedReader leer) {
        ODB odb = ODBFactory.openClient("localhost", 8000, "Cuentas");

        Values val = odb.getValues(new ValuesCriteriaQuery(CuentaCorriente.class)
                .field("Numero")
                .field("Sucursal")
                .field("SaldoActual"));

        while (val.hasNext()) {
            ObjectValues ov = (ObjectValues) val.next();

            System.out.println("Numero: " + ov.getByAlias("Numero")
                    + "\n Sucursal: " + ov.getByAlias("Sucursal")
                    + "\n SaldoActual: " + ov.getByAlias("SaldoActual"));
        }
        odb.close();
    }

    public static void CuentasP(BufferedReader leer) {
        ODB odb = ODBFactory.openClient("localhost", 8000, "Cuentas");

        Values val = odb.getValues(new ValuesCriteriaQuery(CuentaPlazo.class)
                .field("Numero")
                .field("Sucursal")
                .field("SaldoActual"));

        while (val.hasNext()) {
            ObjectValues ov = (ObjectValues) val.next();

            System.out.println("Numero: " + ov.getByAlias("Numero")
                    + "\n Sucursal: " + ov.getByAlias("Sucursal")
                    + "\n SaldoActual: " + ov.getByAlias("SaldoActual"));
        }
        odb.close();
    }

    public static void Movimientos(BufferedReader leer) {
        ODB odb = ODBFactory.openClient("localhost", 8000, "Cuentas");

        Values val = odb.getValues(new ValuesCriteriaQuery(Movimiento.class)
                .field("numeroCta")
                .field("cantidad")
                .field("SaldoAnterior")
                .field("fechaOperacion")
                .field("hora"));

        while (val.hasNext()) {
            ObjectValues ov = (ObjectValues) val.next();

            System.out.println("numeroCta: " + ov.getByAlias("numeroCta")
                    + "\n cantidad: " + ov.getByAlias("cantidad")
                    + "\n SaldoAnterior: " + ov.getByAlias("SaldoAnterior")
                    + "\n Fecha Operacion: " + ov.getByAlias("fechaOperacion")
                    + "\n Hora: " + ov.getByAlias("hora"));
        }
        odb.close();
    }

}
