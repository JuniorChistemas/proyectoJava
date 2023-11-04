package Interfaces;

import java.util.List;

/**
 *
 * @author Jesús
 * @param <ParametroDTO>
 */
public interface IParametro <ParametroDTO>{
    public List<ParametroDTO> listar();                       //lista todos los datos de la tabla  
    public boolean agregar(ParametroDTO obj);         //Agrega datos a la tabla que sera implentado con procedimientos almacenados
    public boolean actualizar(ParametroDTO obj);      //Actualizar 
    public boolean eliminar(String obj);        //Eliminar
    public  ParametroDTO buscar(String obj);  //buscar por ID 
    public List<ParametroDTO> Buscar2(ParametroDTO obj);    //Buscar por nombre o otro tipo de de codigo
    public List <ParametroDTO> listarView();              //Listar atraves de vistas creadas en la base de datos    
    public String Codigo();
    public  List<ParametroDTO> Categoria();
     public  List<ParametroDTO> Marca();
    
}
