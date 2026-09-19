    import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   SISTEMA DE GESTION DE BIBLIOTECA - DEMO EA2   ");
        System.out.println("=================================================\n");

        // 1. CREACIÓN DE AUTORES Y LIBROS (Demostrando Agregación y Herencia)
        Autor autor1 = new Autor("AUT-01", "Gabriel García Márquez", "Colombiana");
        
        // Libro Digital (Subclase que hereda de Libro)
        LibroDigital libroDigital = new LibroDigital(
            "978-0307474728", 
            "Cien Años de Soledad", 
            "EPUB", 
            2.5, 
            "https://biblioteca.iudigital.edu.co/descargas/100-anios.epub"
        );

        // Libro Físico / Estándar
        Libro libroFisico = new Libro("978-8437604947", "Don Quijote de la Mancha");

        // Asociar libros a su autor (Agregación)
        autor1.agregarLibro(libroDigital);
        autor1.agregarLibro(libroFisico);

        // 2. CREACIÓN DE USUARIOS (Demostrando Composición con Dirección)
        Usuario usuario1 = new Usuario(
            "Carlos", "Pérez", "10203040", 
            "Calle 50 #12-30", "Carrera 45", "Medellín", 
            "USR-001", "3001234567"
        );

        Usuario usuario2 = new Usuario(
            "Ana", "Gómez", "98765432", 
            "Avenida 80 #33-10", "Carrera 80", "Bogotá", 
            "USR-002", "3159876543"
        );

        // 3. REGISTRO DE PRÉSTAMOS (Demostrando Asociación)
        System.out.println("--- REGISTRANDO PRÉSTAMOS ---");
        
        // Préstamo 1: Libro Digital a Usuario 1
        Prestamo prestamo1 = new Prestamo("PRST-001", LocalDate.now(), LocalDate.now().plusDays(7), libroDigital);
        usuario1.solicitarPrestamo(prestamo1);

        // Préstamo 2: Libro Físico a Usuario 2
        Prestamo prestamo2 = new Prestamo("PRST-002", LocalDate.now(), LocalDate.now().plusDays(15), libroFisico);
        usuario2.solicitarPrestamo(prestamo2);

        // 4. MOSTRAR RESULTADOS EN CONSOLA
        System.out.println("\n>>> REGISTRO 1:");
        System.out.println("Usuario: " + usuario1.getNombre() + " " + usuario1.getApellido() + " (Doc: " + usuario1.getDocumento() + ")");
        System.out.println("Residencia: " + usuario1.getDireccion().getCalle() + ", " + usuario1.getDireccion().getCiudad());
        System.out.println("Libro Asignado: " + prestamo1.getLibro().getTitulo() + " (Estado: " + libroDigital.getEstado() + ")");
        libroDigital.descargar(); // Método propio de LibroDigital

        System.out.println("\n>>> REGISTRO 2:");
        System.out.println("Usuario: " + usuario2.getNombre() + " " + usuario2.getApellido() + " (Doc: " + usuario2.getDocumento() + ")");
        System.out.println("Residencia: " + usuario2.getDireccion().getCalle() + ", " + usuario2.getDireccion().getCiudad());
        System.out.println("Libro Asignado: " + prestamo2.getLibro().getTitulo() + " (Estado: " + libroFisico.getEstado() + ")");
        System.out.println("Fecha Límite Dev: " + prestamo2.getFechaDevolucion());

        System.out.println("\n=================================================");
        System.out.println("   EJECUCIÓN FINALIZADA CON ÉXITO");
        System.out.println("=================================================");
    }
}