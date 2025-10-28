import java.util.ArrayList;
import java.util.List;

// Clase base
class Empleado {
    String nombre;
    int edad;
    String id;
    double salarioBase;
    int horasTrabajadas;

    public Empleado(String nombre, int edad, String id, double salarioBase, int horasTrabajadas) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.salarioBase = salarioBase;
        this.horasTrabajadas = horasTrabajadas;
    }

    public double calcularSalario() {
        return salarioBase * horasTrabajadas;
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre + ", ID: " + id + ", Salario: $" + calcularSalario();
    }
}

// Subclase: Empleado de ventas
class EmpleadoVentas extends Empleado {
    double comision;

    public EmpleadoVentas(String nombre, int edad, String id, double salarioBase, int horasTrabajadas, double comision) {
        super(nombre, edad, id, salarioBase, horasTrabajadas);
        this.comision = comision;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + comision;
    }
}

// Subclase: Empleado de almacén
class EmpleadoAlmacen extends Empleado {
    double bono;

    public EmpleadoAlmacen(String nombre, int edad, String id, double salarioBase, int horasTrabajadas, double bono) {
        super(nombre, edad, id, salarioBase, horasTrabajadas);
        this.bono = bono;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bono;
    }
}

// Clase principal
public class GestionEmpleados {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();

        empleados.add(new EmpleadoVentas("Ana", 28, "V001", 15.0, 160, 200));
        empleados.add(new EmpleadoVentas("Luis", 35, "V002", 15.0, 150, 150));
        empleados.add(new EmpleadoAlmacen("Carlos", 40, "A001", 12.0, 170, 100));
        empleados.add(new EmpleadoAlmacen("María", 30, "A002", 12.0, 160, 120));

        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }
}
