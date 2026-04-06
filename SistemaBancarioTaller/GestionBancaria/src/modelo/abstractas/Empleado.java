package modelo.abstractas;
import java.time.LocalDate;
import java.time.Period;
import modelo.Excepciones.DatoInvalidoException;
public abstract class Empleado extends Persona {
    private String legajo;
    private LocalDate fechaContratacion;
    protected double salarioBase;
    private boolean activo;
    
    public Empleado(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email,
                    String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo){
        super(id, nombre, apellido, fechaNacimiento, email);
        this.legajo = legajo;
        setFechaContratacion(fechaContratacion);
        setSalarioBase(salarioBase);
        this.activo = activo;
    }
    public void setSalarioBase(double salarioBase){
        if (salarioBase <= 0) {
            throw new DatoInvalidoException("salarioBase", salarioBase);
        }
        this.salarioBase = salarioBase;
    }
    public void setFechaContratacion(LocalDate fechaContratacion){
        if (fechaContratacion == null || fechaContratacion.isAfter(LocalDate.now())) {
            throw new DatoInvalidoException("fechaContratacion", fechaContratacion);
        }
        this.fechaContratacion = fechaContratacion;
    }
    public abstract double calcularSalario();
    public abstract double calcularBono();
    
    public int calcularAntiguedad(){
        return Period.between(fechaContratacion, LocalDate.now()).getYears();
    }
    public boolean isActivo(){
        return activo;
    }
}
