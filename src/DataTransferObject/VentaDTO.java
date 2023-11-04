package DataTransferObject;

import Interfaces.IBuilder;
import java.util.Date;

/**
 *
 * @author Jesús
 * en la clase venta DTO sera utilizada para poder llevar los datos a los formularios de una 
 * manera mas entendible
 */
public class VentaDTO {
    private String IdVenta;
    private String IdUsuario;
    private String IdCliente;
    private Date Fecha;
    private String TipoComprovante;
    private float MontoTotal;
    private float Impuestos;
    private String Estado;
    
    //constructor para insertar la nueva venta

    public VentaDTO(String IdVenta, String IdUsuario, String IdCliente, Date Fecha, String TipoComprovante) {
        this.IdVenta = IdVenta;
        this.IdUsuario = IdUsuario;
        this.IdCliente = IdCliente;
        this.Fecha = Fecha;
        this.TipoComprovante = TipoComprovante;
    }
    //constructor para actualizar

    public VentaDTO(String IdVenta, String IdUsuario, String IdCliente, Date Fecha, String TipoComprovante, float MontoTotal, float Impuestos, String Estado) {
        this.IdVenta = IdVenta;
        this.IdUsuario = IdUsuario;
        this.IdCliente = IdCliente;
        this.Fecha = Fecha;
        this.TipoComprovante = TipoComprovante;
        this.MontoTotal = MontoTotal;
        this.Impuestos = Impuestos;
        this.Estado = Estado;
    }

    public String getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(String IdVenta) {
        this.IdVenta = IdVenta;
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String IdCliente) {
        this.IdCliente = IdCliente;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getTipoComprovante() {
        return TipoComprovante;
    }

    public void setTipoComprovante(String TipoComprovante) {
        this.TipoComprovante = TipoComprovante;
    }

    public float getMontoTotal() {
        return MontoTotal;
    }

    public void setMontoTotal(float MontoTotal) {
        this.MontoTotal = MontoTotal;
    }

    public float getImpuestos() {
        return Impuestos;
    }

    public void setImpuestos(float Impuestos) {
        this.Impuestos = Impuestos;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    public static class VentaDtoBuilder implements IBuilder<VentaDTO>{
            private String IdVenta;
        private String IdUsuario;
        private String IdCliente;
        private Date Fecha;
        private String TipoComprovante;
        private float MontoTotal;
        private float Impuestos;
        private String Estado;
        
        public VentaDtoBuilder() {

        }

        public VentaDtoBuilder setIdVenta(String IdVenta) {
            this.IdVenta = IdVenta;
            return this;
        }

        public VentaDtoBuilder setIdUsuario(String IdVenta) {
            this.IdUsuario = IdVenta;
            return this;
        }

        public VentaDtoBuilder setIdCliente(String IdVenta) {
            this.IdCliente = IdVenta;
            return this;
        }

        public VentaDtoBuilder setFecha(Date fecha) {
            this.Fecha = fecha;
            return this;
        }

        public VentaDtoBuilder setTipoComprovante(String Tipo) {
            this.TipoComprovante = Tipo;
            return this;
        }
        
        public VentaDtoBuilder setMontoTotal(float x){
            this.MontoTotal = x;
            return this;
        }
        public VentaDtoBuilder setImpuesto(float x) {
            this.Impuestos = x;
            return this;
        }
        public VentaDtoBuilder setEstado(String Estado){
            this.Estado = Estado;
            return this;
        }
        
        //builder para agregar
        @Override
        public VentaDTO build() {
            return new VentaDTO(IdVenta, IdUsuario, IdCliente, Fecha, TipoComprovante);
        }
        //builder para actualizar los datos
        @Override
        public VentaDTO buildView() {
            return new VentaDTO(IdVenta, IdUsuario, IdCliente, Fecha, TipoComprovante, MontoTotal, Impuestos, Estado);
        }
        //builder para buscar
        @Override
        public VentaDTO buildBuscar() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    
    
}
