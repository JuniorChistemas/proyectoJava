package BussinessObject;

import DataTransferObject.ParametroDTO;
import Interfaces.IParametro;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class ParametroBO {
  private final IParametro Dao;
  public ParametroBO(IParametro obj){
      this.Dao = obj;
  }
    public String Agregar(String IdParametro,String Descripcion,String Tipo,String Estado){
       boolean estado = false;
        if(Estado.equals("Activo")){
            estado = true;
        }
        ParametroDTO obj = new ParametroDTO.ParametroBuilder().setIdParametro(IdParametro).setDescripcion(Descripcion).setTipo(Tipo).setEstado(estado).build();
        if(Dao.agregar(obj)){
            return "Exito";
        }else{
            return "Error";
        }
    }
    public  List<ParametroDTO>listar(){
        if(Dao.listarView()!=null){
            return Dao.listarView();
        }
        return null;
    }
     public  List<ParametroDTO>listarCategoria(){
        if(Dao.Categoria()!=null){
            return Dao.Categoria();
        }
        return null;
    }
          public  List<ParametroDTO>listarMarca(){
        if(Dao.Marca()!=null){
            return Dao.Marca();
        }
        return null;
    }
    public String CodigoParametro() {
        if (Dao.Codigo() != null) {
            return Dao.Codigo();
        } else {
            return "Error123";
        }
    }
        public String Actualizar(String IdParametro,String Descripcion,String Tipo,String Estado){
       boolean estado = false;
        if(Estado.equals("Activo")){
            estado = true;
        }
        ParametroDTO obj = new ParametroDTO.ParametroBuilder().setIdParametro(IdParametro).setDescripcion(Descripcion).setTipo(Tipo).setEstado(estado).build();
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
            return "Error 123";
        }    
    
}
