package Interfaces;

import java.util.List;

/**
 *
 * @author Jesús
 * @param <T>
 */
public interface IVenta <T>{
    public void Ordenar();

    public List<T> listar();

    public boolean agregar(T obj);

    public boolean actualizar(T obj);

    public boolean eliminar(T obj);

    public T buscar(T obj);

    public List<T> Buscar2(T obj);
    
    public List<T> listarView();//ESTE METODO ES PARA LA VISTA 
    
    public String Codigo();
}
