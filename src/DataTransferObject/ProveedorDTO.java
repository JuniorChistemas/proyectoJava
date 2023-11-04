package DataTransferObject;

/**
 *
 * @author Jesús
 */
public class ProveedorDTO {
    private String IdProveedor;
    private String IdPersona;
    private String Observaciones;
    private String Referencias;
    private boolean Estado;

    public ProveedorDTO(String IdProveedor, String IdPersona, String Observaciones, String Referencias, boolean Estado) {
        this.IdProveedor = IdProveedor;
        this.IdPersona = IdPersona;
        this.Observaciones = Observaciones;
        this.Referencias = Referencias;
        this.Estado = Estado;
    }

    public ProveedorDTO(String IdProveedor, String IdPersona, String Observaciones, String Referencias) {
        this.IdProveedor = IdProveedor;
        this.IdPersona = IdPersona;
        this.Observaciones = Observaciones;
        this.Referencias = Referencias;
    }

    public String getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(String IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public String getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(String IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getReferencias() {
        return Referencias;
    }

    public void setReferencias(String Referencias) {
        this.Referencias = Referencias;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
    
    
}
