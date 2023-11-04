package DataTransferObject;
import Interfaces.IBuilder;
import java.sql.Date;
/**
 *
 * @author Jesús
 */
public class VentaEntity {
     private String IdVenta;
    private String IdUsuario;
    private String IdCliente;
    private Date Fecha;
    private String TipoComprovante;
    private float MontoTotal;
    private float Impuestos;
    private boolean Estado;   

    public VentaEntity(String IdVenta, String IdUsuario, String IdCliente, Date Fecha, String TipoComprovante) {
        this.IdVenta = IdVenta;
        this.IdUsuario = IdUsuario;
        this.IdCliente = IdCliente;
        this.Fecha = Fecha;
        this.TipoComprovante = TipoComprovante;
    }

    public VentaEntity(String IdVenta, String IdUsuario, String IdCliente, Date Fecha, String TipoComprovante, float MontoTotal, float Impuestos, boolean Estado) {
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

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
      public static class VentaEntityBuilder implements IBuilder<VentaEntity>{
            private String IdVenta;
        private String IdUsuario;
        private String IdCliente;
        private Date Fecha;
        private String TipoComprovante;
        private float MontoTotal;
        private float Impuestos;
        private boolean Estado;
        
        public VentaEntityBuilder() {

        }

        public VentaEntityBuilder setIdVenta(String IdVenta) {
            this.IdVenta = IdVenta;
            return this;
        }

        public VentaEntityBuilder setIdUsuario(String IdVenta) {
            this.IdUsuario = IdVenta;
            return this;
        }

        public VentaEntityBuilder setIdCliente(String IdVenta) {
            this.IdCliente = IdVenta;
            return this;
        }

        public VentaEntityBuilder setFecha(Date fecha) {
            this.Fecha = fecha;
            return this;
        }

        public VentaEntityBuilder setTipoComprovante(String Tipo) {
            this.TipoComprovante = Tipo;
            return this;
        }
        
        public VentaEntityBuilder setMontoTotal(float x){
            this.MontoTotal = x;
            return this;
        }
        public VentaEntityBuilder setImpuesto(float x) {
            this.Impuestos = x;
            return this;
        }
        public VentaEntityBuilder setEstado(boolean Estado){
            this.Estado = Estado;
            return this;
        }

        @Override
        public VentaEntity build() {
            return new VentaEntity(IdVenta, IdUsuario, IdCliente, Fecha, TipoComprovante);
        }

        @Override
        public VentaEntity buildView() {
            return new VentaEntity(IdVenta, IdUsuario, IdCliente, Fecha, TipoComprovante, MontoTotal, Impuestos, Estado);
        }

        @Override
        public VentaEntity buildBuscar() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }  
    } 
}
