package BussinessObject;


import Converter.ConverterCliente;
import DataTransferObject.ClienteDTO;
import DataTransferObject.ClienteEntity;
import DataTransferObject.ClienteView;
import Interfaces.ICliente;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class ClienteBO {
    private final ICliente Dao;
    public ClienteBO(ICliente obj){
        this.Dao = obj;
    }
    public String Agregar(String IdCliente,String IdPersona,Date FechaInicio,String Observaciones,String Estado){
        ClienteDTO nuevo = new ClienteDTO(IdCliente, IdPersona, FechaInicio, Observaciones, Estado);
        ConverterCliente c = new ConverterCliente();
        ClienteEntity entidad = c.fromDTO(nuevo);
        if(Dao.agregar(entidad)){
            return "Exito";
        }else{
            return "Error";
        }
    }
    public List<ClienteView>listar(){
        if(Dao.listarDatos()!=null){
            return Dao.listarDatos();
        }
        return null;
    }
    public String CodigoCliente(String x){
        if (Dao.Codigo(x) != null) {
            return Dao.Codigo(x);
        } else {
            return "Error123";
        }
    }
    public ClienteDTO BuscarPorCodigo(String IdCodigo){
        ConverterCliente c = new ConverterCliente();
        ClienteEntity entidad =  (ClienteEntity) Dao.buscar(IdCodigo);
        return c.fromEntity(entidad);
    }
    public ClienteDTO VentaCliente(String x){
        return  (ClienteDTO) Dao.Buscar2(x);
    }
    public String Actualizar(String IdCliente, Date Fechain,String Observaciones,String Estado){
        ConverterCliente c = new ConverterCliente();
        ClienteDTO obj = new ClienteDTO(IdCliente,null, Fechain, Observaciones, Estado);
        ClienteEntity entity =  c.fromDTO(obj);
        if(Dao.actualizar(entity)){
            return "Exito";
        }
        return "error123";
    }
    public String Eliminar(String Id) {
        if (Dao.eliminar(Id)) {
            return "Exito"; 
        }
        return "No se puede eliminar ya que el cliente tiene ventas\n Recomendacion: 'Inhabilitar'\nAccion no permitida ";
    }
}
