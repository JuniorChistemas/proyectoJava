package Interfaces;

import java.util.List;

/**
 *
 * @author Jesús
 * @param <DetalleVentaDTO>
 */
public interface IDetalleVenta<DetalleVentaDTO> {
    public List<DetalleVentaDTO> listar();                       //lista todos los datos de la tabla  
    public boolean agregar(DetalleVentaDTO obj);         //Agrega datos a la tabla que sera implentado con procedimientos almacenados
    public boolean actualizar(DetalleVentaDTO obj);      //Actualizar 
    public boolean eliminar(DetalleVentaDTO obj);        //Eliminar
    public  DetalleVentaDTO buscar(DetalleVentaDTO obj);  //buscar por ID 
    public List<DetalleVentaDTO> Buscar2(DetalleVentaDTO obj);    //Buscar por nombre o otro tipo de de codigo
    public List <DetalleVentaDTO> listarView(String txt);              //Listar atraves de vistas creadas en la base de datos
}
