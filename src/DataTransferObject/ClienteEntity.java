package DataTransferObject;
import java.sql.Date;
/**
 *
 * @author Jesús
 */
public class ClienteEntity {
   private String IdCliente;
    private String IdPersona;
    private Date FechaI;
    private String Observaciones;
    private boolean Estado;

    public ClienteEntity() {
    }

    public ClienteEntity(String IdCliente, String IdPersona, Date FechaI, String Observaciones, boolean Estado) {
        this.IdCliente = IdCliente;
        this.IdPersona = IdPersona;
        this.FechaI = FechaI;
        this.Observaciones = Observaciones;
        this.Estado = Estado;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(String IdPersona) {
        this.IdPersona = IdPersona;
    }

    public Date getFechaI() {
        return FechaI;
    }

    public void setFechaI(Date FechaI) {
        this.FechaI = FechaI;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
    
}
