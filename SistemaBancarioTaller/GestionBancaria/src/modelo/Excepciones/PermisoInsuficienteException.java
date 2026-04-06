package modelo.Excepciones;

public class PermisoInsuficienteException extends BancoRuntimeException{

    public PermisoInsuficienteException(String mensaje) {
        super(mensaje);
    }

}
