    package modelo.Excepciones;

public class DatoInvalidoException extends BancoRuntimeException{
    private String campo;
    private Object valorRecibido;
    public DatoInvalidoException(String campo, Object valorRecibido) {
        super("Datos invalido en el campo: " + campo);
        this.campo = campo;
        this.valorRecibido = valorRecibido;
    }
    public String getCampo(){
        return campo;
    }
    public Object getValorRecibido(){
        return valorRecibido;
    }
}
