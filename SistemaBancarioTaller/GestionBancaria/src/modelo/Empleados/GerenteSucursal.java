package modelo.Empleados;
import modelo.abstractas.Empleado;
import modelo.Excepciones.PermisoInsuficienteException;
import java.time.LocalDate;
public class GerenteSucursal extends Empleado {
    private String sucursal;
    private double presupuestoAnual;

    public GerenteSucursal(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email, String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo, String sucursal, double presupuestoAnual) {
        super(id, nombre, apellido, fechaNacimiento, email, legajo, fechaContratacion, salarioBase, activo);
        this.sucursal = sucursal;
        this.presupuestoAnual = presupuestoAnual;
    }
    @Override
    public double calcularSalario(){
        return salarioBase + calcularBono() * 100000;
    }
    @Override
    public double calcularBono(){
        return calcularAntiguedad() * 100000;
    }
/*    @Override
    public aprobarCredito(){
        ¿Se le tiene que hacer logica a esta mierda¡¡¡¡?
        System.out.println("Credito aprovado");
    }*/
    @Override
    public int calcularEdad(){
        return calcularEdadBase();
    }
    @Override
    public String obtenerTipo(){
        return "Gerente";
    }
    @Override
    public String obtenerDocumentoIdentidad(){
        return "Empleado Getente: ";
    }
    
}
