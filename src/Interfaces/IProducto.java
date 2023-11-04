package Interfaces;

import java.util.List;

/**
 *
 * @author Jesús
 * @param <ProductoDTO>
 */
public interface IProducto <ProductoDTO>{
    public List<ProductoDTO> listar();                       //lista todos los datos de la tabla  
    public boolean agregar(ProductoDTO obj);         //Agrega datos a la tabla que sera implentado con procedimientos almacenados
    public boolean actualizar(ProductoDTO obj);      //Actualizar 
    public boolean eliminar(String obj);        //Eliminar
    public  ProductoDTO buscar(String obj);  //buscar por ID 
    public List<ProductoDTO> Buscar2(String obj);    //Buscar por nombre o otro tipo de de codigo
    public List <ProductoDTO> listarView();              //Listar atraves de vistas creadas en la base de datos  
    public String Codigo();

}
