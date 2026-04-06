package modelo.Personas;

import modelo.abstractas.Persona;
import modelo.Interfaces.*;
import modelo.Enums.TipoDocumento;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClienteNatural extends Persona implements Consultable, Notificable, Auditable {

    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private boolean notificacionesActivas;
    private boolean activo;

    private LocalDateTime fechaCreacion;
    private LocalDateTime ultimaModificacion;
    private String usuarioModificado;

    public ClienteNatural(String id, String nombre, String apellido, LocalDate 
           fechaNacimiento, String email, TipoDocumento tipoDocumento, String numeroDocumento) {
        super(id, nombre, apellido, fechaNacimiento, email);
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.notificacionesActivas = true;
        this.fechaCreacion = LocalDateTime.now();
    }

    @Override
    public int calcularEdad() {
        return calcularEdadBase();
    }

    @Override
    public String obtenerTipo() {
        return "Cliente Natural";
    }

    @Override
    public String obtenerDocumentoIdentidad() {
        return tipoDocumento + ": " + numeroDocumento;
    }

    @Override
    public String obtenerResumen() {
        return getNombreCompleto() + "- " + numeroDocumento;
    }

    @Override
    public void notificar(String mensaje) {
        if (notificacionesActivas) {
            System.out.println("Notificacion: " + mensaje);
        }
    }

    @Override
    public String obtenerContacto() {
        return "email";
    }

    @Override
    public boolean aceptarNotificaciones() {
        return notificacionesActivas;
    }

    @Override
    public LocalDateTime obtenerFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public LocalDateTime obtenerUltimaModificacion() {
        return ultimaModificacion;
    }

    @Override
    public String obtenerUsuarioModificacion() {
        return usuarioModificado;
    }

    @Override
    public void registrarModificacion(String usuario) {
        this.usuarioModificado = usuario;
        this.ultimaModificacion = LocalDateTime.now();
    }

    @Override
    public boolean estaActivo() {
        return activo;
    }
}
