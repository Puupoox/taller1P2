package modelo.Cuentas;
import java.time.LocalDateTime;
import modelo.abstractas.Cuenta;
import modelo.Interfaces.*;
import modelo.Excepciones.*;
public class CuentaCorriente extends Cuenta implements Transaccionable, Auditable, Consultable {
    private double comisionMantenimiento;
    
    public CuentaCorriente(String numeroCuenta, double saldo, double comisionMantenimiento){
        super(numeroCuenta, saldo);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    @Override
    public double calcularInteres() {
        return 0;
    }

    @Override
    public double getLimiteRetiro() {
        return 2000000;
    }

    @Override
    public String getTipoCuenta() {
        return "Corriente";
    }

    @Override
    public void depositar(double monto) throws CuentaBloqueadaException {
        verificarBloqueada();
        saldo+=monto;
    }

    @Override
    public void retirar(double monto) throws SaldoInsuficienteException, CuentaBloqueadaException {
        verificarBloqueada();
        if (monto > saldo) {
            throw new SaldoInsuficienteException(saldo, monto);    
        }
        saldo-=monto;
    }

    @Override
    public double calcularComision(double monto) {
        return comisionMantenimiento;
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public LocalDateTime obtenerFechaCreacion() {
        return LocalDateTime.now();
    }

    @Override
    public LocalDateTime obtenerUltimaModificacion() {
        return LocalDateTime.now();
    }

    @Override
    public String obtenerUsuarioModificacion() {
        return "sistema";
    }

    @Override
    public void registrarModificacion(String usuario) {
        
    }

    @Override
    public String obtenerResumen() {
        return "Cuenta Corriente -- Saldo: " + saldo;
    }

    @Override
    public boolean estaActivo() {
        return !isBloqueada();
    }

    @Override
    public String obtenerTipo() {
        return "Cuenta Corriente";
    }
    
}
