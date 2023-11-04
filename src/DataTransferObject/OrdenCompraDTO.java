package DataTransferObject;

import java.sql.Date;

/**
 *
 * @author Jesús
 */
public class OrdenCompraDTO {
    private String IdOrdenCompra;
    private float MontoT;
    private Date fecha;
    private String IdProveedor;
    private String Marca;
    private boolean Estado;

    public OrdenCompraDTO(String IdOrdenCompra, float MontoT, Date fecha, String IdProveedor, String Marca, boolean Estado) {
        this.IdOrdenCompra = IdOrdenCompra;
        this.MontoT = MontoT;
        this.fecha = fecha;
        this.IdProveedor = IdProveedor;
        this.Marca = Marca;
        this.Estado = Estado;
    }

    public OrdenCompraDTO(String IdOrdenCompra, float MontoT, String IdProveedor, String Marca, boolean Estado) {
        this.IdOrdenCompra = IdOrdenCompra;
        this.MontoT = MontoT;
        this.IdProveedor = IdProveedor;
        this.Marca = Marca;
        this.Estado = Estado;
    }

    public String getIdOrdenCompra() {
        return IdOrdenCompra;
    }

    public void setIdOrdenCompra(String IdOrdenCompra) {
        this.IdOrdenCompra = IdOrdenCompra;
    }

    public float getMontoT() {
        return MontoT;
    }

    public void setMontoT(float MontoT) {
        this.MontoT = MontoT;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(String IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
    
}
