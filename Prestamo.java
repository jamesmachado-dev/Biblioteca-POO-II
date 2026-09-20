import java.time.LocalDate;

public class Prestamo {
    private String idPrestamo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Libro libro; 

    public Prestamo(String idPrestamo, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Libro libro) {
        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
    }

    public boolean estaVencido() {
        return LocalDate.now().isAfter(fechaDevolucion);
    }

    public String getIdPrestamo() { return idPrestamo; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(LocalDate fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }
    public Libro getLibro() { return libro; }
}