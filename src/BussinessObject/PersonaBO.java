package BussinessObject;

import Converter.ConverterPersona;
import DataTransferObject.PersonaDTO;
import DataTransferObject.PersonaEntity;
import Interfaces.IPersona;
import java.util.Date;
/**
 *
 * @author Jesús
 */
public class PersonaBO {
    private final IPersona Dao;
    public PersonaBO(IPersona obj){
        this.Dao = obj;
    }
    public String Agregar(String IdPersona,String Nombre,String Apellido,String NumeroD,String Celular,String Correo,
     String Genero,Date fechaN,String Direccion,String IdParametro,String estado){
        PersonaDTO dto = new PersonaDTO(IdPersona, Nombre, Apellido, NumeroD, Celular, Correo,Genero, fechaN, Direccion, IdParametro,estado);
        ConverterPersona c = new ConverterPersona();
        PersonaEntity entidad = c.fromDTO(dto);
        if(Dao.agregar(entidad)){
            return "Exito";
        }else{
            return "Error";
        }
    }
      public String Actualizar(String IdPersona,String Nombre,String Apellido,String NumeroD,String Celular,String Correo,
     String Genero,Date fechaN,String Direccion,String IdParametro,String estado){
        PersonaDTO dto = new PersonaDTO(IdPersona, Nombre, Apellido, NumeroD, Celular, Correo,Genero, fechaN, Direccion, IdParametro,estado);
        ConverterPersona c = new ConverterPersona();
        PersonaEntity entidad = c.fromDTO(dto);
        if(Dao.actualizar(entidad)){
            return "Exito";
        }else{
            return "Error";
        }
    }
    public String CodigoPersona(){
        if(Dao.Codigo()!=null){
            return Dao.Codigo();
        }else
            return "Error123";
    }
    public PersonaDTO buscar(String codigo){
        ConverterPersona c = new ConverterPersona();
          PersonaEntity obj = (PersonaEntity) Dao.buscar(codigo);
          return c.fromEntity(obj);
    }
    public String Eliminar(String Id) {
        if (Dao.eliminar(Id)) {
            return "Exito";
        }
        return "Error 123";
    }
}
