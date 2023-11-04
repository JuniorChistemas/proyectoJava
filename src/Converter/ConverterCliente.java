package Converter;

import DataTransferObject.ClienteDTO;
import DataTransferObject.ClienteEntity;
import java.util.Date;

/**
 *
 * @author Jesús
 */
public class ConverterCliente extends ConverterGeneral<ClienteEntity, ClienteDTO>{

    // convertir de DTO  a entity
    @Override
    public ClienteEntity fromDTO(ClienteDTO dto) {
       boolean Estado;
       Estado = dto.getEstado().equals("Activo");
        Date date = dto.getFechaI();
       long d = date.getTime();
       java.sql.Date fecha = new java.sql.Date(d);
        ClienteEntity entidad = new ClienteEntity(dto.getIdCliente(), dto.getIdPersona(), fecha, dto.getObservaciones(), Estado);
        return entidad;
    }

    @Override
    public ClienteDTO fromEntity(ClienteEntity entity) {
        String Estado;
        if(entity.isEstado()){
            Estado = "Activo";
        }else{
            Estado = "Inactivo";         
        }
         Date FechaTxt;
        java.sql.Date fecha=entity.getFechaI();
        long d = fecha.getTime();
        FechaTxt = new Date(d);
        ClienteDTO dto = new ClienteDTO(entity.getIdCliente(), entity.getIdPersona(), FechaTxt, entity.getObservaciones(), Estado);
        return dto;
    }
    
}
