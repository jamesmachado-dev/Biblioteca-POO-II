import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
    private String idUsuario;
    private String telefono;
    private List<Prestamo> prestamos; // Agregación/Asociación

    public Usuario(String nombre, String apellido, String documento, String calle, String carrera, String ciudad, String idUsuario, String telefono) {
        super(nombre, apellido, documento, calle, carrera, ciudad); // Herencia de Persona
        this.idUsuario = idUsuario;
        this.telefono = telefono;
        this.prestamos = new ArrayList<>();
    }

    public void solicitarPrestamo(Prestamo prestamo) {
        this.prestamos.add(prestamo);
    }

    public void devolverPrestamo(Prestamo prestamo) {
        this.prestamos.remove(prestamo);
    }

    public String getIdUsuario() { return idUsuario; }
    public void setIdUsuario(String idUsuario) { this.idUsuario = idUsuario; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public List<Prestamo> getPrestamos() { return prestamos; }
}