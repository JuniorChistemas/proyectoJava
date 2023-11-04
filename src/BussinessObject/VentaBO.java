package BussinessObject;

import Converter.ConverterVenta;
import DataTransferObject.VentaDTO;
import DataTransferObject.VentaEntity;
import Interfaces.IVenta;
import java.util.Date;

/**
 *
 * @author Jesús
 */
public class VentaBO {
    private final IVenta Dao;
    public VentaBO(IVenta obj){
        this.Dao = obj;
    }
    public String Agregar(String IdVenta,String IdUsuario,String Cliente,Date Fecha,String TipoComprovante,float montoT,float Impuesto,String estado){
        ConverterVenta entity = new ConverterVenta();
        VentaDTO dto = new VentaDTO(IdVenta, IdUsuario, Cliente, Fecha, TipoComprovante, montoT, Impuesto, estado);
         VentaEntity o = entity.fromDTO(dto);
        if(Dao.agregar(o)){
            return "exito";
        }
        return "ERROR";
    }
        public String Actualizar(String IdVenta,String IdUsuario,String Cliente,Date Fecha,String TipoComprovante,float montoT,float Impuesto,String estado){
        ConverterVenta entity = new ConverterVenta();
        VentaDTO dto = new VentaDTO(IdVenta, IdUsuario, Cliente, Fecha, TipoComprovante, montoT, Impuesto, estado);
        VentaEntity o = entity.fromDTO(dto);
        if(Dao.actualizar(o)){
            return "exito";
        }
        return "ERROR";
    }
     public String CodigoVenta() {
        if (Dao.Codigo() != null) {
            return Dao.Codigo();
        } else {
            return "Error123";
        }
    }
}
