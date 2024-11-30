import java.util.HashMap;
import java.util.Map;

public class Universidad {
    private HashMap<String, Estudiante> estudiantes;

    public Universidad() {
        this.estudiantes = new HashMap<>();
    }

    public HashMap<String, Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(HashMap<String, Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void agregarEstudiante(String nombre, int edad) {
        if (!estudiantes.containsKey(nombre)) {
            Estudiante estudiante = new Estudiante(nombre, edad);
            estudiantes.put(nombre,estudiante);
            System.out.println("Estudiante agregado: " + nombre);
        }else {
            System.out.println("El estudiante ya existe");
        }
    }

    public void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados");
        }else {
            for (Map.Entry<String, Estudiante> entry : estudiantes.entrySet()){
                System.out.println("Nombre: " + entry.getKey());
                System.out.println("Edad: " + entry.getValue().getEdad());
                System.out.println("Promedio: " + entry.getValue().calcularPromedio());
                System.out.println("***********");
            }
        }
    }
    public void buscarEstudiante(String nombre) {
        Estudiante estudiante = estudiantes.get(nombre);
        if (estudiante != null) {
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Edad: " + estudiante.getEdad());
            System.out.println("Promedio: " + estudiante.calcularPromedio());
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }
}
