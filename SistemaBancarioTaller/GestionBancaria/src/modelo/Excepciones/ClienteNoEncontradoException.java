package modelo.Excepciones;

public class ClienteNoEncontradoException extends SistemaBancarioException{
    private String idCliente;
    public ClienteNoEncontradoException(String idCliente) {
        super("Cliente no encontrado", "ERR_CLIENTE");
        this.idCliente = idCliente;
    }
    public String getIdCliente(){
        return idCliente;
    }
    
}
