public class Libro {
    protected String isbn;
    protected String titulo;
    protected EstadoLibro estado;

    public Libro(String isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.estado = EstadoLibro.DISPONIBLE;
    }

    public boolean estaDisponible() {
        return this.estado == EstadoLibro.DISPONIBLE;
    }

    public void prestar() {
        this.estado = EstadoLibro.PRESTADO;
    }

    public void devolver() {
        this.estado = EstadoLibro.DISPONIBLE;
    }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public EstadoLibro getEstado() { return estado; }
    public void setEstado(EstadoLibro estado) { this.estado = estado; }
}