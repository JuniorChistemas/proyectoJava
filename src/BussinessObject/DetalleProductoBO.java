package BussinessObject;

import DataTransferObject.DetalleProductoDTO;
import Interfaces.IDetalleProducto;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class DetalleProductoBO {
    private final IDetalleProducto Dao;
    public DetalleProductoBO (IDetalleProducto obj){
        this.Dao = obj;
    }
       public String Agregar(String IdVenta,String IdProducto,int cantidad,float total,float Descuento){
        DetalleProductoDTO obj = new DetalleProductoDTO(IdVenta, IdProducto, cantidad, total, Descuento);
        if(Dao.agregar(obj)){
            return "Exito";
        }
        return "Error";
    }
    public List<DetalleProductoDTO>listar(String txt){
        if(Dao.listarView(txt)!=null){
            return Dao.listarView(txt);
        }
        return null;
    }
}
