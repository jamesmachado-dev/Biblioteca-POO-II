import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
    private String idUsuario;
    private String telefono;
    private List<Prestamo> prestamos; 

    public Usuario(String nombre, String apellido, String documento, String calle, String carrera, String ciudad, String idUsuario, String telefono) {
        super(nombre, apellido, documento, calle, carrera, ciudad); 
        this.idUsuario = idUsuario;
        this.telefono = telefono;
        this.prestamos = new ArrayList<>();
    }

    public Prestamo solicitarPrestamo(Libro libro) {
        if (libro.estaDisponible()) {
            libro.setEstado(EstadoLibro.PRESTADO);
            
            
            String idPrestamo = "PRES-" + (this.prestamos.size() + 1);
            Prestamo nuevoPrestamo = new Prestamo(idPrestamo, LocalDate.now(), LocalDate.now().plusDays(15), libro);
            
            this.prestamos.add(nuevoPrestamo);
            System.out.println(">> Préstamo aprobado: " + libro.getTitulo() + " asignado a " + this.getNombre());
            return nuevoPrestamo;
        } else {
            System.out.println(">> Rechazado: El libro '" + libro.getTitulo() + "' no está disponible.");
            return null;
        }
    }

    public void devolverPrestamo(Prestamo prestamo) {
        if (this.prestamos.contains(prestamo)) {
            prestamo.getLibro().setEstado(EstadoLibro.DISPONIBLE);
            this.prestamos.remove(prestamo);
            System.out.println(">> Devolución exitosa del préstamo: " + prestamo.getIdPrestamo());
        }
    }

   
    public String getIdUsuario() { return idUsuario; }
    public void setIdUsuario(String idUsuario) { this.idUsuario = idUsuario; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public List<Prestamo> getPrestamos() { return prestamos; }
}
