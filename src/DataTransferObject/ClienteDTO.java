package DataTransferObject;

import java.util.Date;

/**
 *
 * @author Jesús
 */
public class ClienteDTO {
    private String IdCliente;
    private String IdPersona;
    private Date FechaI;
    private String Observaciones;
    private String Estado;

    public ClienteDTO(){
    }
    public ClienteDTO(String IdCliente, String IdPersona, Date FechaI, String Observaciones, String Estado) {
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

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
}