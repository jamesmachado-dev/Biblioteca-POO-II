public class Libro {
    private String isbn;
    private String titulo;
    private EstadoLibro estado;

    public Libro(String isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.estado = EstadoLibro.DISPONIBLE;
    }

    public boolean estaDisponible() {
        return this.estado == EstadoLibro.DISPONIBLE;
    }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public EstadoLibro getEstado() { return estado; }
    public void setEstado(EstadoLibro estado) { this.estado = estado; }
}