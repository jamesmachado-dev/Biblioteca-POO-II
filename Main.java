   import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------");
        System.out.println("   SISTEMA DE GESTIÓN DE BIBLIOTECA - DEMO FINAL  ");
        System.out.println("--------------------------------------------------\n");

        
        Libro libroFisico = new Libro("978-0415", "Don Quijote de la Mancha");
        LibroDigital libroDigital = new LibroDigital("978-1234", "Cien Años de Soledad", "EPUB", 2.5, "https://biblio.edu.co/cien-anios");

    
        System.out.println("=== CATÁLOGO (DEMOSTRANDO POLIMORFISMO) ===");
        List<Libro> catalogo = new ArrayList<>();
        catalogo.add(libroFisico);   
        catalogo.add(libroDigital);  

        for (Libro libro : catalogo) {
            
            System.out.println("- " + libro.getTitulo() + " | ¿Disponible?: " + libro.estaDisponible());
        }

        
        Usuario usuario1 = new Usuario("Carlos", "Pérez", "102030", "Calle 50", "Cra 43", "Medellin", "USR-001", "300123");

        
        System.out.println("\n=== GESTIÓN DE PRÉSTAMOS ===");
        Prestamo prestamo1 = usuario1.solicitarPrestamo(libroFisico); 
        Prestamo prestamo2 = usuario1.solicitarPrestamo(libroDigital);
        
  
        usuario1.solicitarPrestamo(libroFisico); 

        
        System.out.println("\n=== DEMOSTRANDO SOBRECARGA EN LIBRO DIGITAL ===");
        libroDigital.descargar();                         
        libroDigital.descargar(usuario1.getNombre());     

        System.out.println("\n--------------------------------------------------");
        System.out.println("           EJECUCIÓN FINALIZADA CON ÉXITO:-)     ");
        System.out.println("--------------------------------------------------");
    }
}
