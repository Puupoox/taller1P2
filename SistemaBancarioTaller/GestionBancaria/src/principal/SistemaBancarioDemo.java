package principal;

import modelo.Banco.Banco;
import modelo.Personas.*;
import modelo.Cuentas.*;
import modelo.Enums.*;
import modelo.Excepciones.*;
import modelo.Interfaces.*;
import modelo.cuentas.CuentaAhorros;
import modelo.abstractas.*;
import java.time.LocalDate;
import java.util.Scanner;


public class SistemaBancarioDemo {

    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco("Banco POO");

        Persona[] clientes = new Persona[10];
        Cuenta[] cuentas = new Cuenta[20];

        int contClientes = 0;
        int contCuentas = 0;

        int opcion;

        do {
            System.out.println("\n==============================");
            System.out.println("   SISTEMA BANCARIO POO");
            System.out.println("==============================");
            System.out.println("1. Registrar Cliente Natural");
            System.out.println("2. Registrar Cliente Empresarial");
            System.out.println("3. Crear Cuenta");
            System.out.println("4. Depositar");
            System.out.println("5. Retirar");
            System.out.println("6. Transferir");
            System.out.println("7. Ver Cuentas");
            System.out.println("0. Salir");
            System.out.print("👉 Seleccione: ");

            opcion = sc.nextInt();
            sc.nextLine();

            try {

                switch (opcion) {

                    case 1:
                        System.out.println("\n--- REGISTRAR CLIENTE NATURAL ---");

                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Apellido: ");
                        String apellido = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        ClienteNatural cn = new ClienteNatural(
                                id, nombre, apellido,
                                LocalDate.of(2000, 1, 1),
                                email,
                                TipoDocumento.CEDULA, id
                        );

                        clientes[contClientes++] = cn;
                        banco.registrarCliente(cn);

                        System.out.println(" Cliente natural registrado");
                        break;

                    case 2:
                        System.out.println("\n--- REGISTRAR CLIENTE EMPRESARIAL ---");

                        System.out.print("ID: ");
                        String idE = sc.nextLine();

                        System.out.print("Nombre empresa: ");
                        String nombreE = sc.nextLine();

                        System.out.print("Email: ");
                        String emailE = sc.nextLine();

                        ClienteEmpresarial ce = new ClienteEmpresarial(
                                idE, nombreE, "",
                                LocalDate.of(2000, 1, 1),
                                emailE,
                                "NIT" + idE,
                                nombreE,
                                "Representante"
                        );

                        clientes[contClientes++] = ce;
                        banco.registrarCliente(ce);

                        System.out.println("✅ Cliente empresarial registrado");
                        break;

                    case 3:
                        System.out.println("\n--- CREAR CUENTA ---");

                        System.out.print("Numero de cuenta: ");
                        String numero = sc.nextLine();

                        System.out.print("Saldo inicial: ");
                        double saldo = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("Tipo (1=Ahorros, 2=Corriente, 3=Credito): ");
                        int tipo = sc.nextInt();
                        sc.nextLine();

                        Cuenta nuevaCuenta = null;

                        if (tipo == 1) {
                            nuevaCuenta = new CuentaAhorros("001", 10000, 0.05);
                        } else if (tipo == 2) {
                            nuevaCuenta = new CuentaCorriente("002", 20000, 10000);
                        } else {
                            nuevaCuenta = new CuentaCredito("003", 5000000, 500000, 0.03);
                        }

                        cuentas[contCuentas++] = nuevaCuenta;
                        banco.abrirCuenta(null, nuevaCuenta);

                        System.out.println("✅ Cuenta creada");
                        break;

                    case 4:
                        System.out.println("\n-- DEPOSITAR ---");

                        for (int i = 0; i < contCuentas; i++) {
                            System.out.println(i + ". " + cuentas[i].getTipoCuenta());
                        }

                        System.out.print("Seleccione cuenta: ");
                        int idxD = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Monto: ");
                        double monto = sc.nextDouble();
                        sc.nextLine();

                        ((Transaccionable) cuentas[idxD]).depositar(monto);

                        System.out.println(" Depósito realizado en cuenta " + idxD);
                        break;


                    case 5:
                        System.out.println("\n--- RETIRAR ---");

                        for (int i = 0; i < contCuentas; i++) {
                            System.out.println(i + ". " + cuentas[i].getTipoCuenta());
                        }

                        System.out.print("Seleccione cuenta: ");
                        int idxR = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Monto: ");
                        double montoR = sc.nextDouble();
                        sc.nextLine();

                        ((Transaccionable) cuentas[idxR]).retirar(montoR);

                        System.out.println(" Retiro realizado de cuenta " + idxR);
                        break;

                    case 6:
                        System.out.println("\n--- TRANSFERENCIA ---");

                        for (int i = 0; i < contCuentas; i++) {
                            System.out.println(i + ". " + cuentas[i].getTipoCuenta());
                        }

                        System.out.print("Cuenta origen: ");
                        int origen = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Cuenta destino: ");
                        int destino = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Monto: ");
                        double montoT = sc.nextDouble();
                        ((Transaccionable) cuentas[origen]).retirar(montoT);
                        ((Transaccionable) cuentas[destino]).depositar(montoT);

                        System.out.println(" Transferencia realizada");
                        break;

                    case 7:
                        System.out.println("\n--- LISTA DE CUENTAS ---");

                        for (int i = 0; i < contCuentas; i++) {
                            System.out.println("Cuenta " + i + " | Tipo: " +
                                    cuentas[i].getTipoCuenta() +
                                    " | Saldo: " + ((Transaccionable) cuentas[i]).consultarSaldo());
                        }
                        break;

                    case 0:
                        System.out.println(" Saliendo");
                        break;

                    default:
                        System.out.println(" Opción inválida");
                }

            } catch (Exception e) {
                System.out.println(" Error: " + e.getMessage());
            }

        } while (opcion != 0);

        sc.close();
    }
}