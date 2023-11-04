package BussinessObject;

import DataTransferObject.DetalleVentaDTO;
import Interfaces.IDetalleVenta;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class DetalleVentaBO {
     private final IDetalleVenta Dao;
    public DetalleVentaBO(IDetalleVenta obj){
        this.Dao = obj;
    }   
    public String Agregar(String IdVenta,String IdProducto,int cantidad,float total,float Descuento){
        DetalleVentaDTO obj = new DetalleVentaDTO(IdVenta, IdProducto, cantidad, total, Descuento);
        if(Dao.agregar(obj)){
            return "Exito";
        }
        return "Error";
    }
    public List<DetalleVentaDTO>listar(String txt){
        if(Dao.listarView(txt)!=null){
            return Dao.listarView(txt);
        }
        return null;
    }
}
