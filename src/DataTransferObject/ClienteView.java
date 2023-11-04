package DataTransferObject;
/**
 *
 * @author Jesús
 */
public class ClienteView {
    private String IdCliente;
    private String Nombre;
    private String Apellido;
    private String NumeroD;
    private String Genero;
    private String Direccion;
    private String estado;

    public ClienteView(){
    }

    public ClienteView(String IdCliente, String Nombre, String Apellido, String NumeroD, String Genero, String Direccion, String estado) {
        this.IdCliente = IdCliente;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.NumeroD = NumeroD;
        this.Genero = Genero;
        this.Direccion = Direccion;
        this.estado = estado;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNumeroD() {
        return NumeroD;
    }

    public void setNumeroD(String NumeroD) {
        this.NumeroD = NumeroD;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
