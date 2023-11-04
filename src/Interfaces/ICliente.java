package Interfaces;
import DataTransferObject.ClienteView;
import java.util.List;

/**
 *
 * @author Jesús
 * @param <Entity>
 * @param <DTO>
 * 
 */
public interface ICliente <Entity,DTO>{
    public List<DTO> listar();                       //lista todos los datos de la tabla  
    public boolean agregar(Entity obj);         //Agrega datos a la tabla que sera implentado con procedimientos almacenados
    public boolean actualizar(Entity obj);      //Actualizar 
    public boolean eliminar(String obj);        //Eliminar
    public  Entity buscar(String obj);  //buscar por ID 
    public DTO Buscar2(String obj);    //Buscar por nombre o otro tipo de de codigo
    public List <DTO> listarView();              //Listar atraves de vistas creadas en la base de datos  
    public List<ClienteView> listarDatos();
    public String Codigo(String x);
}
