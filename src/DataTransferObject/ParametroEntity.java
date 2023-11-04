package DataTransferObject;

/**
 *
 * @author Jesús
 */
public class ParametroEntity {
      //ps.registerOutParameter(4, java.sql.Types.INTEGER);
    private String IdParametro;
    private String Descripcion;
    private String Tipo;
    private boolean Estado;

    public ParametroEntity(String IdParametro, String Descripcion, String Tipo, boolean Estado) {
        this.IdParametro = IdParametro;
        this.Descripcion = Descripcion;
        this.Tipo = Tipo;
        this.Estado = Estado;
    }

    public String getIdParametro() {
        return IdParametro;
    }

    public void setIdParametro(String IdParametro) {
        this.IdParametro = IdParametro;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
    
    
}
