package modelo.Banco;
import java.time.LocalDate;
import java.time.LocalDateTime;
import modelo.abstractas.Cuenta;
import modelo.Enums.EstadoTransaccion;
import modelo.Excepciones.EstadoTransaccionInvalidoException;
public class Transaccion {
    private String id;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private double monto;
    private EstadoTransaccion estado;
    private LocalDateTime fecha;
    private String descripcion;

    public Transaccion(String id, Cuenta origen, Cuenta destino, double monto, String descripcion) {
        this.id = id;
        this.cuentaOrigen = origen;
        this.cuentaDestino = destino;
        this.monto = monto;
        this.estado = EstadoTransaccion.PENDIENTE;
        this.fecha = LocalDateTime.now();
        this.descripcion = descripcion;
    }
    public void cambiarEstado(EstadoTransaccion nuevo){
        switch (estado) {
            case PENDIENTE:
                if (nuevo == EstadoTransaccion.PROCESANDO || nuevo == EstadoTransaccion.RECHAZADA) {
                    estado = nuevo;
                    return;
                }
                break;
            case PROCESANDO:
                if (nuevo == EstadoTransaccion.REVERTIDA) {
                    estado = nuevo;
                    return;
                } 
                break;
            case COMPLETADA:
                if (nuevo == EstadoTransaccion.REVERTIDA) {
                    estado = nuevo;
                    return;
                }
                break;
            default:
                break;
        }
        throw new EstadoTransaccionInvalidoException("No se puede pasar de " + estado + "a " + nuevo);
    }
    public String generarComprobante(){
        return "Transaccion: " + id +
                "\nMonto: " + monto +
                "\nEstado: " + estado +
                "\nFecha: " + fecha + 
                "\nDescripcion: " + descripcion;
    }
    
}
