public class LibroDigital extends Libro {
    private String formato;
    private double tamanioMB;
    private String urlDescarga;

    
    public LibroDigital(String isbn, String titulo, String formato, double tamanioMB, String urlDescarga) {
        super(isbn, titulo);
        this.formato = formato;
        this.tamanioMB = tamanioMB;
        this.urlDescarga = urlDescarga;
    }

    // Aca se cumple el requisito: Sobrescritura de método (@Override) ---
    @Override
    public boolean estaDisponible() {
        return true; 
    }


    public void descargar() {
        System.out.println("Descargando libro digital desde: " + urlDescarga);
    }

  
    public void descargar(String nombreUsuario) {
        System.out.println("El usuario " + nombreUsuario + " está descargando el libro en formato " + formato);
    }

    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }
    public double getTamanioMB() { return tamanioMB; }
    public void setTamanioMB(double tamanioMB) { this.tamanioMB = tamanioMB; }
    public String getUrlDescarga() { return urlDescarga; }
    public void setUrlDescarga(String urlDescarga) { this.urlDescarga = urlDescarga; }
}
