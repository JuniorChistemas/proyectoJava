package DataTransferObject;

import Interfaces.IBuilder;

/**
 *
 * @author Jesús
 */
public class DetalleProductoDTO {
    private String IdDeatelleProducto;
    private String IdProducto;
    private int Cantidad;
    private float PrecioComprar;
    private float Total;

    public DetalleProductoDTO(String IdDeatelleProducto, String IdProducto, int Cantidad, float PrecioComprar, float Total) {
        this.IdDeatelleProducto = IdDeatelleProducto;
        this.IdProducto = IdProducto;
        this.Cantidad = Cantidad;
        this.PrecioComprar = PrecioComprar;
        this.Total = Total;
    }

    public String getIdDeatelleProducto() {
        return IdDeatelleProducto;
    }

    public void setIdDeatelleProducto(String IdDeatelleProducto) {
        this.IdDeatelleProducto = IdDeatelleProducto;
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

    public float getPrecioComprar() {
        return PrecioComprar;
    }

    public void setPrecioComprar(float PrecioComprar) {
        this.PrecioComprar = PrecioComprar;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }
    

}
