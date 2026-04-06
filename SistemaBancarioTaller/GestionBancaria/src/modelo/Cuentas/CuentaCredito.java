package modelo.Cuentas;
import java.time.LocalDateTime;
import modelo.abstractas.Cuenta;
import modelo.Interfaces.*;
import modelo.Excepciones.*;

public class CuentaCredito extends Cuenta implements Transaccionable, Consultable, Auditable{
    private double limiteCredito;
    private double deudaActual;
    private double tasaInteres;
    
    
    private LocalDateTime ultimaModificacion;
    private String usuarioModificado;
    
    public CuentaCredito(String numeroCuenta, double saldoInicial, double limiteCredito, double tasaInteres) {
        super(numeroCuenta, saldoInicial);
        this.limiteCredito = limiteCredito;
        this.tasaInteres = tasaInteres;
        this.deudaActual = 0;
        this.ultimaModificacion = LocalDateTime.now();
    }
    @Override
    public void depositar(double monto) throws CuentaBloqueadaException{
        verificarBloqueada();
        if (monto <= 0) {
            throw new DatoInvalidoException("monto", monto);
        }
        deudaActual -= monto;
        if (deudaActual <0) {
            deudaActual = 0;
        }
    }

    @Override
    public void retirar(double monto) throws CuentaBloqueadaException, SaldoInsuficienteException{
        verificarBloqueada();
        if (monto <= 0) {
            throw new DatoInvalidoException("monto", monto);
        }
        if (deudaActual + monto > limiteCredito) {
            throw new SaldoInsuficienteException(limiteCredito, monto);
        }
        deudaActual += monto;
    }
    @Override
    public double calcularComision(double monto){
        return monto * 0.02;
    }
    @Override
    public double consultarSaldo(){
        return limiteCredito - deudaActual;
    }
    @Override
    public double calcularInteres(){
        return deudaActual * tasaInteres / 12;
    }
    @Override
    public double getLimiteRetiro(){
        return limiteCredito;
    }
    @Override
    public String getTipoCuenta(){
        return "Credito";
    }
    @Override
    public String obtenerResumen(){
        return "cuenta credito - disponible " + consultarSaldo();
    }
    @Override
    public boolean estaActivo(){
        return !isBloqueada();
    }
    @Override
    public String obtenerTipo(){
        return "Cuenta Credito";
    }
    @Override
    public LocalDateTime obtenerFechaCreacion(){
        return null;
    }
    @Override
    public LocalDateTime obtenerUltimaModificacion(){
        return ultimaModificacion;
    }
    @Override
    public String obtenerUsuarioModificacion(){
        return usuarioModificado;
    }
    @Override
    public void registrarModificacion(String usuario){
        this.usuarioModificado = usuario;
        this.ultimaModificacion = LocalDateTime.now();
    }


}
