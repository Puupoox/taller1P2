package modelo.Excepciones;

public class EstadoTransaccionInvalidoException extends BancoRuntimeException{

    public EstadoTransaccionInvalidoException(String mensaje) {
        super(mensaje);
    }

}
