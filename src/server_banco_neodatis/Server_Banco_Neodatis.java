package server_banco_neodatis;

import Metodos.Visualizar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

/**
 *
 * @author a16alfonsofa
 */
public class Server_Banco_Neodatis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ODBServer server = ODBFactory.openServer(8000);
        server.addBase("Cuentas", "Cuentas.neo");
        //se pueden añadir varias bases de datos

        server.startServer(true);

        int opc;
        do {
            System.out.println("-----------MENÚ-----------");
            System.out.println("1_Consultar Clientes");
            System.out.println("2_Consultar Cuentas Corrientes");
            System.out.println("3_Consultar Cuentas Plazos");
            System.out.println("4_Consultar Movimientos");
            System.out.println("5_EXIT");
            System.out.print("         Elegir opción:\n>");
            opc = Integer.parseInt(leer.readLine());

            switch (opc) {
                case 1:
                    Visualizar.Clientes(leer);
                    break;
                case 2:
                    Visualizar.CuentasC(leer);
                    break;
                case 3:
                    Visualizar.CuentasP(leer);
                    break;
                case 4:
                    Visualizar.Movimientos(leer);
                    break;
                case 5:
                    server.close();
                    break;
            }
        } while (opc != 5);
    }

}
