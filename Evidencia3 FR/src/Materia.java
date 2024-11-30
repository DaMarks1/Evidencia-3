public class Materia {
    private String nombre;
    private double calificacion;

    public Materia(String nombre, double calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    @Override
    public String toString(){
        return "Estudiante: " + nombre + "Calificacion: " + calificacion;
    }
}
