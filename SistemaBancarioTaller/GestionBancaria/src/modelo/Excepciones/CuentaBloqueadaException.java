package modelo.Excepciones;

public class CuentaBloqueadaException extends SistemaBancarioException{

    public CuentaBloqueadaException() {
        super("La cuenta esta bloqueada", "ERR_BLOQUEO");
    }

}
