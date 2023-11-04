package Interfaces;

import java.util.List;

/**
 *
 * @author Jesús
 * @param <T>
 */
public interface IProveedor <T>{
    public void Ordenar();

    public List<T> listar();

    public boolean agregar(T obj);

    public boolean actualizar(T obj);

    public boolean eliminar(String obj);

    public T buscar(T obj);

    public T Buscar2(String obj);
    
    public List<T> listarView();//ESTE METODO ES PARA LA VISTA 
    
    public String Codigo(String text);
}
