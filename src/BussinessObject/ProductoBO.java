package BussinessObject;

import DataTransferObject.ProductoDTO;
import Interfaces.IProducto;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class ProductoBO {
    private final IProducto Dao;
    public ProductoBO(IProducto obj){
        this.Dao = obj;
    }
    public String Agregar(String IdProducto,String Nombre,boolean Estado,int Stock,float PrecioV,String IdParametro){
        ProductoDTO obj = new ProductoDTO.ProductoBuilder().setIdProducto(IdProducto).setNombre(Nombre).setEstado(Estado).setStock(Stock).setPrecioV(PrecioV).setIdParametro(IdParametro).build();
        if(Dao.agregar(obj)){
            return "Exito";
        }else{
            return "Error";
        }
    }
    public List<ProductoDTO>listar(){
               if(Dao.listarView()!=null){
            return Dao.listarView();
        }
        return null; 
    }
     public List<ProductoDTO>listarProductoVenta(){
               if(Dao.Buscar2("hola")!=null){
            return Dao.Buscar2("hola");
        }
        return null; 
    }
        public String CodigoProducto() {
        if (Dao.Codigo() != null) {
            return Dao.Codigo();
        } else {
            return "Error123";
        }
    }
         public String Actualizar(String IdProducto,String Nombre,boolean Estado,int Stock,float PrecioV,String IdParametro){
        ProductoDTO obj = new ProductoDTO.ProductoBuilder().setIdProducto(IdProducto).setNombre(Nombre).setEstado(Estado).setStock(Stock).setPrecioV(PrecioV).setIdParametro(IdParametro).build();
        if(Dao.actualizar(obj)){
            return "Exito";
        }else{
            return "Error";
        }
    }
               public String Eliminar(String Id){
            if(Dao.eliminar(Id)){
                return "Exite";
            }
            return "El producto es necesario para el sistema\n Recomendacion: 'Inhabilitar' ";
        }    
}
