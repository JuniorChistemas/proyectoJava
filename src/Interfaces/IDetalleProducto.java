package Interfaces;

import java.util.List;

/**
 *
 * @author Jesús
 * @param <DetalleProductoDTO>
 */
public interface IDetalleProducto<DetalleProductoDTO> {
    public List<DetalleProductoDTO> listar();                       //lista todos los datos de la tabla  
    public boolean agregar(DetalleProductoDTO obj);         //Agrega datos a la tabla que sera implentado con procedimientos almacenados
    public boolean actualizar(DetalleProductoDTO obj);      //Actualizar 
    public boolean eliminar(DetalleProductoDTO obj);        //Eliminar
    public  DetalleProductoDTO buscar(DetalleProductoDTO obj);  //buscar por ID 
    public List<DetalleProductoDTO> Buscar2(DetalleProductoDTO obj);    //Buscar por nombre o otro tipo de de codigo
    public List <DetalleProductoDTO> listarView(String x);              //Listar atraves de vistas creadas en la base de datos
}
