import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String idAutor;
    private String nombre;
    private String nacionalidad;
    private List<Libro> libros; // Agregación

    public Autor(String idAutor, String nombre, String nacionalidad) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        if (libro != null && !libros.contains(libro)) {
            libros.add(libro);
        }
    }

    public void quitarLibro(Libro libro) {
        libros.remove(libro);
    }

    public String getIdAutor() { return idAutor; }
    public void setIdAutor(String idAutor) { this.idAutor = idAutor; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
    public List<Libro> getLibros() { return libros; }
}