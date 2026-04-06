package modelo.Excepciones;

public class SaldoInsuficienteException extends SistemaBancarioException{
    
    private double saldoActual;
    private double montoSolicitado;

    public SaldoInsuficienteException(double mensaje, double codigoError) {
        super("Saldo Insuficiente", "ERR_SALDO");
        this.saldoActual = saldoActual;
        this.montoSolicitado = montoSolicitado;
    }
    public double getSaldoActual(){
        return saldoActual;
    }
    public double getMontoSolicitado(){
        return montoSolicitado;
    }
}
