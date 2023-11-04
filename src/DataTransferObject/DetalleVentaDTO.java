package DataTransferObject;

/**
 *
 * @author Jesús
 */
public class DetalleVentaDTO {
    private String IdVenta;
    private String IdProducto;
    private int Cantidad;
    private float PrecioUnitario;
    private float Descuento;

    public DetalleVentaDTO( String IdVenta, String IdProducto, int Cantidad, float PrecioUnitario, float Descuento) {
        this.IdVenta = IdVenta;
        this.IdProducto = IdProducto;
        this.Cantidad = Cantidad;
        this.PrecioUnitario = PrecioUnitario;
        this.Descuento = Descuento;
    }
    

    public String getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(String IdVenta) {
        this.IdVenta = IdVenta;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(float PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public float getDescuento() {
        return Descuento;
    }

    public void setDescuento(float Descuento) {
        this.Descuento = Descuento;
    }
    
}
