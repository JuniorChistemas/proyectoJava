package BussinessObject;

import DataTransferObject.UsuarioDTO;
import Interfaces.IUsuario;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class UsuarioBO {
    private final IUsuario Dao;
    public UsuarioBO(IUsuario obj){
        this.Dao = obj;
    }
    public String Agregar(String IdUsuario,String IdPersona,float Sueldo,String Password,String IdParametro,boolean estado){
        
       // boolean estado = Estado.equals("Activo");
        UsuarioDTO u = new UsuarioDTO.UsuarioBuilder().setIdUsuario(IdUsuario).setIdPersona(IdPersona).setIdParametro(IdParametro).setPassword(Password).setSueldo(Sueldo).IsEstado(estado).build();
        if(Dao.agregar(u)){
            return "Exito";
        }else{
            return "Accion no permitidad, consulte con el administrador";
        }
    }
        public  List<UsuarioDTO>listar(){
        if(Dao.listar()!=null){
            return Dao.listar();
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
    public String Actualizar(String IdUsuario, String IdPersona, float Sueldo, String Password, String IdParametro, boolean Estado) {

      //  boolean estado = Estado.equals("Activo");
        UsuarioDTO u = new UsuarioDTO.UsuarioBuilder().setIdUsuario(IdUsuario).setIdPersona(null).setIdParametro(IdParametro).setPassword(Password).setSueldo(Sueldo).IsEstado(Estado).build();
        if (Dao.actualizar(u)) {
            return "Exito";
        } else {
            return "Accion no permitidad!!";
        }
    }

    public String Eliminar(String Id) {
        if (Dao.eliminar(Id)) {
            return "Exito";
        }
        return "Usuario es necesario para el sistema.\nAccion no permitida.";
    }
    public UsuarioDTO Buscar(String IdCodigo){
        return (UsuarioDTO) Dao.buscar(IdCodigo);
    }
     public UsuarioDTO BuscarVenta(String IdCodigo){
        return (UsuarioDTO) Dao.Buscar2(IdCodigo);
    }
}
