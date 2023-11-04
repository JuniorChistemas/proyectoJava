package DataTransferObject;

import java.sql.Date;

/**
 *
 * @author Jesús
 */
public class PersonaEntity {
    private String IdPersona;
    private String Nombre;
    private String Apellido;
    private String NumeroDucumento;
    private String Celular;
    private String Correo;
    private boolean Genero;
    private Date FechaNac;
    private String Direccion;
    private String IdParametro;
    private boolean Estado;

    public PersonaEntity(String IdPersona, String Nombre, String Apellido, String NumeroDucumento, String Celular, String Correo, boolean Genero, Date FechaNac, String Direccion, String IdParametro, boolean Estado) {
        this.IdPersona = IdPersona;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.NumeroDucumento = NumeroDucumento;
        this.Celular = Celular;
        this.Correo = Correo;
        this.Genero = Genero;
        this.FechaNac = FechaNac;
        this.Direccion = Direccion;
        this.IdParametro = IdParametro;
        this.Estado = Estado;
    }

    public String getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(String IdPersona) {
        this.IdPersona = IdPersona;
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

    public String getNumeroDucumento() {
        return NumeroDucumento;
    }

    public void setNumeroDucumento(String NumeroDucumento) {
        this.NumeroDucumento = NumeroDucumento;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public boolean isGenero() {
        return Genero;
    }

    public void setGenero(boolean Genero) {
        this.Genero = Genero;
    }

    public Date getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(Date FechaNac) {
        this.FechaNac = FechaNac;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getIdParametro() {
        return IdParametro;
    }

    public void setIdParametro(String IdParametro) {
        this.IdParametro = IdParametro;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

}
