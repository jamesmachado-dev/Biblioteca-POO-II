import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
    private static final int DIAS_PRESTAMO = 15;
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
        if (libro == null || !libro.estaDisponible()) {
            return null;
        }
        libro.prestar(); // polimorfismo: el físico se bloquea, el digital no
        String idPrestamo = "PRES-" + idUsuario + "-" + (prestamos.size() + 1);
        LocalDate hoy = LocalDate.now();
        Prestamo nuevoPrestamo = new Prestamo(idPrestamo, hoy, hoy.plusDays(DIAS_PRESTAMO), libro);
        prestamos.add(nuevoPrestamo);
        return nuevoPrestamo;
    }

    public void devolverPrestamo(Prestamo prestamo) {
        if (prestamo != null && prestamos.remove(prestamo)) {
            prestamo.getLibro().devolver();
        }
    }

   
    public String getIdUsuario() { return idUsuario; }
    public void setIdUsuario(String idUsuario) { this.idUsuario = idUsuario; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public List<Prestamo> getPrestamos() { return prestamos; }
}
