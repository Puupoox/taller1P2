package modelo.Empleados;

import modelo.abstractas.Empleado;
import java.time.LocalDate;

public class AsesorFinanciero extends Empleado {

    private double comisionBase;
    private double metasMensuales;

    public AsesorFinanciero(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email, String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo, double comisionBase, double metasMensuales){
        super(id, nombre, apellido, fechaNacimiento, email, legajo, fechaContratacion, salarioBase, activo);
        this.comisionBase = comisionBase;
        this.metasMensuales = metasMensuales;
    }
    @Override
    public double calcularSalario(){
        return salarioBase + calcularBono();
    }
    @Override
    public double calcularBono(){
        if (metasMensuales > 1000000) {
            return comisionBase;
        }
        return 0;
    }
    @Override
    public int calcularEdad(){
        return calcularEdadBase();
    }
    @Override
    public String obtenerTipo(){
        return "Asesor Financiero";
    }
    @Override
    public String obtenerDocumentoIdentidad(){
        return "Empleado asesor";
    }
}
