package modelo.Excepciones;

public class CapacidadExcedidaException extends SistemaBancarioException{
    private int capacidadMaxima;
    public CapacidadExcedidaException(int capacidadMaxima) {
        super("Capacidad maxima alcanzada", "ERR_CAPACIDAD");
        this.capacidadMaxima = capacidadMaxima;
    }
    public int getCapacidadMaxima(){
        return capacidadMaxima;
    }
}
