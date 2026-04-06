package modelo.empleados;

import modelo.abstractas.Empleado;
import modelo.Enums.Turno;

import java.time.LocalDate;

public class Cajero extends Empleado {

    private Turno turno;
    private int transaccionesDia;
    private String sucursalAsignada;

    public Cajero(String id, String nombre, String apellido,
                  LocalDate fechaNacimiento, String email,
                  String legajo, LocalDate fechaContratacion,
                  double salarioBase, boolean activo,
                  Turno turno) {

        super(id, nombre, apellido, fechaNacimiento, email,
              legajo, fechaContratacion, salarioBase, activo);

        this.turno = turno;
        this.transaccionesDia = 0;
        this.sucursalAsignada = "Principal";
    }

    @Override
    public double calcularSalario() {
        return salarioBase + calcularBono();
    }

    @Override
    public double calcularBono() {
        return transaccionesDia * 1000;
    }

    @Override
    public int calcularEdad() {
        return calcularEdadBase();
    }

    @Override
    public String obtenerTipo() {
        return "Cajero";
    }

    @Override
    public String obtenerDocumentoIdentidad() {
        return "Empleado Cajero - " + turno;
    }

    public void registrarTransaccion() {
        transaccionesDia++;
    }
}