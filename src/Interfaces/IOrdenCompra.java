package Interfaces;

import java.util.List;

/**
 *
 * @author Jesús
 * @param <OrdenCompraDTO>
 */
public interface IOrdenCompra <OrdenCompraDTO>{
    public List<OrdenCompraDTO> listar();                       //lista todos los datos de la tabla  
    public boolean agregar(OrdenCompraDTO obj);         //Agrega datos a la tabla que sera implentado con procedimientos almacenados
    public boolean actualizar(OrdenCompraDTO obj);      //Actualizar 
    public boolean eliminar(OrdenCompraDTO obj);        //Eliminar
    public  OrdenCompraDTO buscar(OrdenCompraDTO obj);  //buscar por ID 
    public List<OrdenCompraDTO> Buscar2(OrdenCompraDTO obj);    //Buscar por nombre o otro tipo de de codigo
    public List <OrdenCompraDTO> listarView();              //Listar atraves de vistas creadas en la base de datos
    public String Codigo(String X);
}
