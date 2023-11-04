package DataTransferObject;

import Interfaces.IBuilder;

/**
 *
 * @author Jesús
 */
public class ParametroDTO {
     private String IdParamero;
    private String Descripcion;
    private String tipo;
    private boolean estado;
    private String EstadoText;
    
    public ParametroDTO(String  IdParamero, String Descripcion, String tipo, boolean estado) {
        this.IdParamero = IdParamero;
        this.Descripcion = Descripcion;
        this.tipo = tipo;
        this.estado = estado;
    }

     public ParametroDTO(String  IdParamero, String Descripcion, String tipo, String EstadoText) {
        this.IdParamero = IdParamero;
        this.Descripcion = Descripcion;
        this.tipo = tipo;
        this.EstadoText = EstadoText;
    }
    public String getIdParamero() {
        return IdParamero;
    }

    public void setIdParamero(String IdParamero) {
        this.IdParamero = IdParamero;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getEstadoText() {
        return EstadoText;
    }

    public void setEstadoText(String EstadoText) {
        this.EstadoText = EstadoText;
    }

    @Override
    public String toString() {
        return "ParametroDTO{" + "IdParamero=" + IdParamero + ", Descripcion=" + Descripcion + ", tipo=" + tipo + ", estado=" + estado + '}';
    }

    
    
    public static class ParametroBuilder implements IBuilder<ParametroDTO>{
        private String IdParamero;
        private String Descripcion;
        private String tipo;
        private boolean estado;
        private String EstadoText;
        
        public ParametroBuilder(){            
        }
        
        public ParametroBuilder setIdParametro(String IdParametro){
            this.IdParamero = IdParametro;
            return this;
        }
        public ParametroBuilder setDescripcion(String Descripcion){
            this.Descripcion = Descripcion;
            return this;
        }
        public ParametroBuilder setTipo(String tipo){
            this.tipo = tipo;
            return this;
        }
        public ParametroBuilder setEstado(boolean Estado){
            this.estado = Estado;
            return this;
        }
        public ParametroBuilder setEstadoText(String EstadoText){
            this.EstadoText = EstadoText;
            return this;
        }
        @Override
        public ParametroDTO build() {
            return new ParametroDTO(IdParamero, Descripcion, tipo, estado);
        }

        @Override
        public ParametroDTO buildView() {
            return new ParametroDTO(IdParamero, Descripcion, tipo, EstadoText);
        }

        @Override
        public ParametroDTO buildBuscar() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
}
