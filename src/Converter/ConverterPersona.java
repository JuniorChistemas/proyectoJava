package Converter;

import DataTransferObject.PersonaDTO;
import DataTransferObject.PersonaEntity;
import java.util.Date;


/**
 *
 * @author Jesús Junior Martinez Chunga
 */
public class ConverterPersona extends ConverterGeneral<PersonaEntity, PersonaDTO>{

    //convertir de dto a entity
    @Override
    public PersonaEntity fromDTO(PersonaDTO dto) {
       boolean genero;
       boolean estado;
       genero = dto.getGenero().equals("Masculino");
       estado = dto.getEstado().equals("Activo");
       Date date = dto.getFechaNac();
       long d = date.getTime();
       java.sql.Date fecha = new java.sql.Date(d);
         PersonaEntity entidad = new PersonaEntity(dto.getIdPersona(), dto.getNombre(), dto.getApellido(), dto.getNumeroDucumento(), dto.getCelular(), dto.getCorreo(), genero, fecha, dto.getDireccion(), dto.getIdParametro(), estado);
         return entidad;
    }
    //convertir de Entity a DTO
    @Override
    public PersonaDTO fromEntity(PersonaEntity entity) {
        String genero= "Femenino";
        String estado = "Inactivo";
        if(entity.isGenero()){
             genero = "Masculino";  
        }
        if(entity.isEstado()){
            estado = "Activo";
        }
        Date FechaTxt;
        java.sql.Date fecha=entity.getFechaNac();
        long d = fecha.getTime();
        FechaTxt = new Date(d);     
        PersonaDTO dto = new PersonaDTO(entity.getIdPersona(), entity.getNombre(), entity.getApellido(), entity.getNumeroDucumento(),entity.getCelular(), entity.getCorreo(), genero, FechaTxt, entity.getDireccion(),entity.getIdParametro(), estado);
        return dto;
    }
    
}
