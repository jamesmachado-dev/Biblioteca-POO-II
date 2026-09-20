import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------");
        System.out.println("   SISTEMA DE GESTIÓN DE BIBLIOTECA - DEMO FINAL  ");
        System.out.println("--------------------------------------------------\n");

        // 1. AUTOR Y LIBROS (agregación Autor - Libro)
        Autor autor = new Autor("AUT-01", "Gabriel García Márquez", "Colombiana");
        Libro libroFisico = new Libro("978-0415", "Don Quijote de la Mancha");
        LibroDigital libroDigital = new LibroDigital("978-1234", "Cien Años de Soledad", "EPUB", 2.5, "https://biblio.edu.co/cien-anios");

        autor.agregarLibro(libroFisico);
        autor.agregarLibro(libroDigital);
        System.out.println("Autor: " + autor.getNombre()
                + " | Libros registrados: " + autor.getLibros().size());


        //2. APLICACIÓN DE POLIMORFISMO
        System.out.println("=== CATÁLOGO (DEMOSTRANDO POLIMORFISMO) ===");
        List<Libro> catalogo = new ArrayList<>();
        catalogo.add(libroFisico);   
        catalogo.add(libroDigital);  

        for (Libro libro : catalogo) {
            System.out.println("- " + libro.getTitulo()
                    + " | Estado: " + libro.getEstado()
                    + " | ¿Disponible?: " + libro.estaDisponible());
        }

        // 3. USUARIOS
        Usuario usuario1 = new Usuario("Carlos", "Pérez", "102030", "Calle 50", "Cra 43", "Medellin", "USR-001", "300123");
        usuario1.actualizarDireccion("Calle 52", "Cra 45", "Medellín");
        System.out.println("\nUsuario: " + usuario1.getNombre() + " " + usuario1.getApellido()
                + " | Dirección: " + usuario1.getDireccion().getCalle()
                + ", " + usuario1.getDireccion().getCiudad());

        // 4. PRÉSTAMOS
        System.out.println("\n=== GESTIÓN DE PRÉSTAMOS ===");
        Prestamo prestamo1 = usuario1.solicitarPrestamo(libroFisico);
        reportar(libroFisico, prestamo1);
        Prestamo prestamo2 = usuario1.solicitarPrestamo(libroDigital);
        reportar(libroDigital, prestamo2);


        // El físico ya está prestado -> se rechaza
        reportar(libroFisico, usuario1.solicitarPrestamo(libroFisico));

        // El digital tiene copias ilimitadas -> se aprueba otra vez
        reportar(libroDigital, usuario1.solicitarPrestamo(libroDigital));

        System.out.println("Préstamos activos: " + usuario1.getPrestamos().size());
        System.out.println("¿Préstamo del físico vencido?: " + prestamo1.estaVencido()
                + " (vence el " + prestamo1.getFechaDevolucion() + ")");


        //5. SOBREGARGA
        System.out.println("\n=== DEMOSTRANDO SOBRECARGA EN LIBRO DIGITAL ===");
        libroDigital.descargar();                         
        libroDigital.descargar(usuario1.getNombre());


        // 6. DEVOLUCIÓN
        System.out.println("\n=== DEVOLUCIÓN ===");
        usuario1.devolverPrestamo(prestamo1);
        System.out.println(libroFisico.getTitulo() + " -> " + libroFisico.getEstado()
                + " | ¿Disponible?: " + libroFisico.estaDisponible());
        System.out.println("Préstamos activos: " + usuario1.getPrestamos().size());

        System.out.println("\n--------------------------------------------------");
        System.out.println("           EJECUCIÓN FINALIZADA CON ÉXITO:-)     ");
        System.out.println("--------------------------------------------------");
    }
    private static void reportar(Libro libro, Prestamo prestamo) {
        if (prestamo == null) {
            System.out.println(">> Rechazado: '" + libro.getTitulo() + "' no está disponible.");
        } else {
            System.out.println(">> Aprobado " + prestamo.getIdPrestamo() + ": '"
                    + libro.getTitulo() + "' (estado del libro: " + libro.getEstado() + ")");
        }
    }
}
