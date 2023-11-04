package Converter;

import DataTransferObject.VentaDTO;
import DataTransferObject.VentaEntity;
import java.util.Date;

/**
 *
 * @author Jesús
 */
public class ConverterVenta extends ConverterGeneral<VentaEntity, VentaDTO> {

    @Override
    public VentaEntity fromDTO(VentaDTO dto) {
       boolean Estado = dto.getEstado().equals("Activo");
        Date date = dto.getFecha();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        VentaEntity entidad = new VentaEntity(dto.getIdVenta(), dto.getIdUsuario(), dto.getIdCliente(), fecha, dto.getTipoComprovante(), dto.getMontoTotal(), dto.getImpuestos(), Estado);
        return entidad;
    }

    @Override
    public VentaDTO fromEntity(VentaEntity entity) {
      String estado = "Inactivo";
        if(entity.isEstado()){
            estado = "Activo";
        }
        Date FechaTxt;
         java.sql.Date fecha=entity.getFecha();
         long d = fecha.getTime();
        FechaTxt = new Date(d);     
        
        VentaDTO dto = new VentaDTO(entity.getIdVenta(), entity.getIdUsuario(), entity.getIdCliente(), FechaTxt, entity.getTipoComprovante(), entity.getMontoTotal(),entity.getImpuestos(), estado);
        return dto;
    }
    
}
