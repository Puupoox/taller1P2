package modelo.Interfaces;
import modelo.Excepciones.*;
public interface Transaccionable {
    void depositar(double monto) throws CuentaBloqueadaException;
    void retirar(double monto) throws   SaldoInsuficienteException, CuentaBloqueadaException;
    double calcularComision(double monto);
    double consultarSaldo();
}
