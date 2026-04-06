package modelo.Excepciones;

public class BancoRuntimeException extends RuntimeException{
    public BancoRuntimeException(String mensaje){
        super(mensaje);
    }
}
