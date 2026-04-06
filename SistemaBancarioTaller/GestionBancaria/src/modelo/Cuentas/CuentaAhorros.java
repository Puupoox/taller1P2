package modelo.cuentas;

import modelo.abstractas.Cuenta;
import modelo.Interfaces.*;
import modelo.Excepciones.*;

public class CuentaAhorros extends Cuenta implements Transaccionable, Consultable, Auditable {

    private double tasaInteres;

    public CuentaAhorros(String numeroCuenta, double saldo, double tasaInteres) {
        super(numeroCuenta, saldo);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public double calcularInteres() {
        return saldo * tasaInteres / 12;
    }

    @Override
    public double getLimiteRetiro() {
        return 1000000;
    }

    @Override
    public String getTipoCuenta() {
        return "Ahorros";
    }

    @Override
    public void depositar(double monto) throws CuentaBloqueadaException {
        verificarBloqueada();
        saldo += monto;
    }

    @Override
    public void retirar(double monto) throws SaldoInsuficienteException, CuentaBloqueadaException {
        verificarBloqueada();

        if (monto > saldo) {
            throw new SaldoInsuficienteException(saldo, monto);
        }

        saldo -= monto;
    }

    @Override
    public double calcularComision(double monto) {
        return monto * 0.01;
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public String obtenerResumen() {
        return "Cuenta Ahorros | Saldo: " + saldo;
    }

    @Override
    public boolean estaActivo() {
        return !isBloqueada();
    }

    @Override
    public String obtenerTipo() {
        return "Cuenta Ahorros";
    }

    @Override
    public java.time.LocalDateTime obtenerFechaCreacion() {
        return java.time.LocalDateTime.now();
    }

    @Override
    public java.time.LocalDateTime obtenerUltimaModificacion() {
        return java.time.LocalDateTime.now();
    }

    @Override
    public String obtenerUsuarioModificacion() {
        return "sistema";
    }

    @Override
    public void registrarModificacion(String usuario) {}
}