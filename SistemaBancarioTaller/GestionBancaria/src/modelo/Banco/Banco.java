package modelo.Banco;

import java.lang.constant.Constable;
import modelo.abstractas.*;
import modelo.Excepciones.*;

public class Banco {

    private String nombre;

    private Empleado[] empleados = new Empleado[50];
    private int contadorEmpleados = 0;

    private Persona[] clientes = new Persona[200];
    private int contadorClientes = 0;

    private Cuenta[] cuentas = new Cuenta[500];
    private int contadorCuentas = 0;

    public Banco(String nombre) {
        this.nombre = nombre;
    }

    public void registrarCliente(Persona c) throws CapacidadExcedidaException {
        if (contadorClientes >= clientes.length) {
            throw new CapacidadExcedidaException(clientes.length);
        }
        clientes[contadorClientes++] = c;
    }

    public Persona buscarCliente(String id) throws ClienteNoEncontradoException {
        for (int i = 0; i < contadorClientes; i++) {
            if (clientes[i] != null && clientes[i].getNombreCompleto().equals(id)) {
                return clientes[i];
            }
        }
        throw new ClienteNoEncontradoException(id);
    }

    public void registrarEmpleado(Empleado e) throws CapacidadExcedidaException {
        if (contadorEmpleados >= empleados.length) {
            throw new CapacidadExcedidaException(empleados.length);
        }
        empleados[contadorEmpleados++] = e;
    }

    public void abrirCuenta(Persona cliente, Cuenta c) throws CapacidadExcedidaException {
        if (contadorCuentas >= cuentas.length) {
            throw new CapacidadExcedidaException(cuentas.length);
        }
        cuentas[contadorCuentas++] = c;
    }
    
    public double calcularNominaTotal(){
        double total = 0;
        for(int i = 0; i < contadorEmpleados; i++){
            total += empleados[i].calcularSalario();
        }
        return total;
    }
    
    public void calcularInteresMensuales(){
        for (int i = 0; i < contadorCuentas; i++) {
            double interes = cuentas[i].calcularInteres();
            System.out.println("Interes Generado: "+ interes);
        }
    }
}
