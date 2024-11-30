import java.util.HashMap;

public class Estudiante {
    private String nombre;
    private int edad;
    private HashMap<String, Materia> calificaciones;

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificaciones = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public HashMap<String, Materia> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(HashMap<String, Materia> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public void agregarMateria(String nombreMateria, double calificacion) throws CalificacionInvalidaException {
        if (calificacion < 0 || calificacion > 100) {
            throw new CalificacionInvalidaException("Calificación inválida: " + calificacion);
        }
        Materia materia = new Materia(nombreMateria, calificacion);
        calificaciones.put(nombreMateria, materia);
    }
    public double calcularPromedio() {
        return calificaciones.values().stream().mapToDouble(Materia::getCalificacion).average().orElse(0.0);
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Materias: ");
        for (Materia materia : calificaciones.values()){
            System.out.println("-" + materia.getNombre() + ": " + materia.getCalificacion());
        }
        System.out.println("Promedio: " + calcularPromedio());
    }
    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", materias=" + calificaciones.values() +
                ", promedio=" + calcularPromedio() +
                '}';
    }
}
