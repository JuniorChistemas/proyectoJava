package Converter;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Jesús
 * @param <E>
 * @param <D>
 */
public abstract class ConverterGeneral<E,D>{
    public abstract E fromDTO(D dto); //retorna una entidad
    public abstract D fromEntity(E entity);//retorna  un dto para que sea mas clara para el usuario
   public List<E> fromDto(List<D> dtos){ 
    if(dtos == null) return null; 
        return (List<E>) dtos.stream().map(dto -> fromDto((List<D>) dto)).collect(Collectors.toList()); 
 }  
 public List<D> fromEntity(List<E> entities){ 
     if(entities == null) return null; 
     return entities.stream()  .map(entity -> fromEntity(entity)).collect(Collectors.toList()); 
 } 
}
