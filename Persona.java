public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String documento;
    private Direccion direccion; // Composición

    public Persona(String nombre, String apellido, String documento, String calle, String carrera, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.direccion = new Direccion(calle, carrera, ciudad);
    }

    public void actualizarDireccion(String calle, String carrera, String ciudad) {
        this.direccion.setCalle(calle);
        this.direccion.setCarrera(carrera);
        this.direccion.setCiudad(ciudad);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public Direccion getDireccion() { return direccion; }
}