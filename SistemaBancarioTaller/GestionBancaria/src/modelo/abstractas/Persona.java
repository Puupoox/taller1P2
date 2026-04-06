package modelo.abstractas;
import java.time.LocalDate;
import java.time.Period;
import modelo.Excepciones.DatoInvalidoException;
public abstract class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String email;
    
    public Persona(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email){
        setId(id);
        this.nombre = nombre;
        this.apellido = apellido;
        setFechaNacimiento(fechaNacimiento);
        setEmail(email);
    }
    
    public void setId(String id){
        if (id == null || id.isEmpty()) {
            throw new DatoInvalidoException("id", id);
        }
        this.id = id;
    }
    
    public void setEmail(String email){
        if (email == null || !email.contains("@")) {
            throw new DatoInvalidoException("email", email);
        } 
        this.email = email;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento){
        if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())) {
            throw new DatoInvalidoException("FechaNacimiento", fechaNacimiento);
        }
        this.fechaNacimiento = fechaNacimiento;
    }
    public abstract int calcularEdad();
    public abstract String obtenerTipo();
    public abstract String obtenerDocumentoIdentidad();
    
    public String getNombreCompleto(){
        return nombre + "" + apellido;
    }
    protected int calcularEdadBase(){
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
