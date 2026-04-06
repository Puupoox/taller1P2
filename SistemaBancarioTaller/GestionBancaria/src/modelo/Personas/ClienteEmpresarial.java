package modelo.Personas;
import modelo.abstractas.Persona;
import modelo.Interfaces.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClienteEmpresarial extends Persona implements Consultable, Notificable, Auditable{
    private String nit;
    private String razonSocial;
    private String representanteLegal;
    private boolean notificacionesActivas;
    
    private LocalDateTime fechaCreacion;
    private LocalDateTime ultimaModificacion;
    private String usuaruiModificacion;

    public ClienteEmpresarial(String id, String nombre, String apellido,
                              LocalDate fechaNacimiento, String email,
                              String nit, String razonSocial, String representanteLegal) {
        super(id, nombre, apellido, fechaNacimiento, email);
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.representanteLegal = representanteLegal;
        this.notificacionesActivas = true;
        this.fechaCreacion = fechaCreacion;
        
    }
    @Override
    public int calcularEdad(){
        return calcularEdadBase();
    }
    @Override
    public String obtenerTipo(){
        return "Cliente Empresarial";
    }
    @Override
    public String obtenerDocumentoIdentidad(){
        return "NIT: " + nit;
    }
    @Override 
    public String obtenerContacto(){
        return "email";
    }
    @Override
    public String obtenerResumen(){
        return razonSocial + "- " + nit;
    }
    @Override
    public boolean estaActivo(){
        return true;
    }
    @Override
    public void notificar(String mensaje){
        if (notificacionesActivas) {
            System.out.println("Empresa notificada: " + mensaje);
        }
    }
    @Override
    public boolean aceptarNotificaciones(){
        return notificacionesActivas;
    }
    @Override
    public LocalDateTime obtenerFechaCreacion(){
        return fechaCreacion;
    }
    @Override
    public LocalDateTime obtenerUltimaModificacion(){
        return ultimaModificacion;
    }
    @Override
    public String obtenerUsuarioModificacion(){
        return usuaruiModificacion;
    }
    @Override
    public void registrarModificacion(String usuario){
        this.usuaruiModificacion = usuario;
        this.ultimaModificacion = LocalDateTime.now();
    }
}
