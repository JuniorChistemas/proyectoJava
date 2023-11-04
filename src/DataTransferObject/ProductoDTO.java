package DataTransferObject;

import Interfaces.IBuilder;

/**
 *
 * @author Jesús
 */
public class ProductoDTO {
    private String IdProducto;
    private String Nombre;
    private boolean Estado;
    private int Stock;
    private float PrecioV;
    private String IdParametro;
    private String EstadoTxt;
    public ProductoDTO(String IdProducto, String Nombre, boolean Estado, int Stock, float PrecioV, String IdParametro) {
        this.IdProducto = IdProducto;
        this.Nombre = Nombre;
        this.Estado = Estado;
        this.Stock = Stock;
        this.PrecioV = PrecioV;
        this.IdParametro = IdParametro;
    }

    public ProductoDTO(String IdProducto, String Nombre, int Stock, float PrecioV, String IdParametro, String EstadoTxt) {
        this.IdProducto = IdProducto;
        this.Nombre = Nombre;
        this.Stock = Stock;
        this.PrecioV = PrecioV;
        this.IdParametro = IdParametro;
        this.EstadoTxt = EstadoTxt;
    }

    public ProductoDTO(String IdProducto, String Nombre, int Stock,float Precio) {
        this.IdProducto = IdProducto;
        this.Nombre = Nombre;
        this.Stock = Stock;
        this.PrecioV = Precio;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public float getPrecioV() {
        return PrecioV;
    }

    public void setPrecioV(float PrecioV) {
        this.PrecioV = PrecioV;
    }

    public String getIdParametro() {
        return IdParametro;
    }

    public void setIdParametro(String IdParametro) {
        this.IdParametro = IdParametro;
    }

    public String getEstadoTxt() {
        return EstadoTxt;
    }

    public void setEstadoTxt(String EstadoTxt) {
        this.EstadoTxt = EstadoTxt;
    }
    public static class ProductoBuilder implements IBuilder<ProductoDTO>{
        private String IdProducto;
        private String Nombre;
        private boolean Estado;
        private int Stock;
        private float PrecioV;
        private String IdParametro;
        private String EstadoTxt;
        
        public ProductoBuilder(){
            
        }
        public ProductoBuilder setIdProducto(String IdProducto){
            this.IdProducto = IdProducto;
            return this;
        }
        public ProductoBuilder setNombre(String Nombre){
            this.Nombre = Nombre;
            return this;
        }
        public ProductoBuilder setEstado(boolean Estado){
            this.Estado = Estado;
            return this;
        }
        public ProductoBuilder setStock(int Stock){
            this.Stock = Stock;
            return this;
        }
        public ProductoBuilder setPrecioV(float PrecioV){
            this.PrecioV = PrecioV;
            return this;
        }
        public ProductoBuilder setIdParametro(String IdParametro){
            this.IdParametro = IdParametro;
            return this;
        }
        public ProductoBuilder setEstadoTxt(String Estado){
            this.EstadoTxt = Estado;
            return this;
        }
        @Override
        public ProductoDTO build() {
            return new ProductoDTO(IdProducto, Nombre, Estado, Stock, PrecioV, IdParametro);
        }

        @Override
        public ProductoDTO buildView() {
            return new ProductoDTO(IdProducto, Nombre, Stock, PrecioV, IdParametro, EstadoTxt);
        }

        @Override
        public ProductoDTO buildBuscar() {
            return new ProductoDTO(IdProducto, Nombre, Stock,PrecioV);
        }
        
    }
    
    
    
}
