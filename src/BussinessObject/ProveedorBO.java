package BussinessObject;

import DataTransferObject.ProveedorDTO;
import Interfaces.IProveedor;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class ProveedorBO {
    private final IProveedor Dao;
    public ProveedorBO(IProveedor obj){
        this.Dao = obj;
    }
    public String Agregar(String IdProveedor,String IdPersona,String Observaciones, String Referencias,boolean Estado){
        ProveedorDTO dto = new ProveedorDTO(IdProveedor, IdPersona, Observaciones, Referencias, Estado);
        if(Dao.agregar(dto)){
            return "Exito";
        }
        return "Error";
    }
      public String Actualizar(String IdProveedor,String IdPersona,String Observaciones, String Referencias,boolean Estado){
        ProveedorDTO dto = new ProveedorDTO(IdProveedor, IdPersona, Observaciones, Referencias, Estado);
        if(Dao.actualizar(dto)){
//            return "Exito";
        }
        return "Error";
    }
      public List<ProveedorDTO> listarProveedor(){
          System.out.println("ingreso al metodo");
          if(Dao.listar()!=null){
              System.out.println("encontre datos");
              return Dao.listar();
          }
          System.out.println("no encontre datos");
          return null;
      }
         public String Eliminar(String Id) {
        if (Dao.eliminar(Id)) {
            return "Exito";
        }
        return "Error 123";
    }
          public String CodigoCliente(String x){
        if (Dao.Codigo(x) != null) {
            return Dao.Codigo(x);
        } else {
            return "Error123";
        }
    }
     public ProveedorDTO VentaCliente(String x){
        return  (ProveedorDTO) Dao.Buscar2(x);
    }
}
