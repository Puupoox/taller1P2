package modelo.abstractas;
import java.time.LocalDateTime;
import modelo.Banco.Transaccion;
import modelo.Excepciones.*;
public abstract class Cuenta {
    private String numeroCuenta;
    protected double saldo;
    private boolean bloqueada;
    
    private LocalDateTime fechaCreacion;
    private LocalDateTime ultimaModificacion;
    private String usuarioModificado;
    
    private Transaccion[] historial = new Transaccion[20];
    private int contadorTransacciones = 0;
    
    public Cuenta(String numeroCuenta, double saldoInicial){
        this.numeroCuenta = numeroCuenta;
        this.saldo  = saldoInicial;
        this.bloqueada = false;
        this.fechaCreacion = LocalDateTime.now();
    }
    public void verificarBloqueada() throws CuentaBloqueadaException{
        if (bloqueada) {
            throw new CuentaBloqueadaException();
        }
    }
    public void agrgarAlHistorial(Transaccion t) throws CapacidadExcedidaException{
        if (contadorTransacciones >= historial.length) {
            throw new CapacidadExcedidaException(historial.length);
        }
        historial[contadorTransacciones ++] = t;
    }
    
    public Transaccion[] getHistorial(){
        Transaccion[] copia = new Transaccion[contadorTransacciones];
        System.arraycopy(historial, 0, copia, 0, contadorTransacciones);
        return copia;
    }
    public abstract double calcularInteres();
    public abstract double getLimiteRetiro();
    public abstract String getTipoCuenta();
    
    public double getSaldo(){
        return saldo;
    }
    
    public boolean isBloqueada(){
        return bloqueada;
    }
    public void setBloqueada(boolean bloqueada){
        this.bloqueada = bloqueada;
    }

}
