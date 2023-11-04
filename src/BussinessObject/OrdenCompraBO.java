package BussinessObject;

import DataTransferObject.OrdenCompraDTO;
import Interfaces.IOrdenCompra;
import java.util.Date;

/**
 *
 * @author Jesús
 */
public class OrdenCompraBO {
    private final IOrdenCompra Dao; 
    public OrdenCompraBO(IOrdenCompra obj ){
        this.Dao = obj;
    }
    public String Agregar(String IdCompra,float Monto,String IdProveedor,String Marca,boolean Estado){
        OrdenCompraDTO obj = new OrdenCompraDTO(IdCompra, Monto, IdProveedor, Marca, Estado);
        if(Dao.agregar(obj)){
            return "Exito";
        }
        return "Error";
    }
     public String Actualizar(String IdCompra,float Monto,Date Fecha,String IdProveedor,String Marca,boolean Estado){
        long d = Fecha.getTime();
       java.sql.Date fecha = new java.sql.Date(d);
        OrdenCompraDTO obj = new OrdenCompraDTO(IdCompra, Monto,fecha, IdProveedor, Marca, Estado);
        if(Dao.actualizar(obj)){
            return "Exito";
        }
        return "Error";
    }
         public String CodigoVenta(String y) {
        if (Dao.Codigo(y) != null) {
            return Dao.Codigo(y);
        } else {
            return "Error123";
        }
    }
}
