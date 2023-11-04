package Implementacion;

import Interfaces.ICliente;
import Interfaces.IDetalleProducto;
import Interfaces.IDetalleVenta;
import Interfaces.IOrdenCompra;
import Interfaces.IParametro;
import Interfaces.IPersona;
import Interfaces.IProducto;
import Interfaces.IProveedor;
import Interfaces.IUsuario;
import Interfaces.IVenta;
import Type.BaseDatos;

/**
 *
 * @author Jesús
 */
public interface IDaoGeneral {
    public IPersona PersonaClass(BaseDatos obj);
    public IUsuario UsuarioClass(BaseDatos obj);
    public ICliente ClienteClass(BaseDatos obj);
    public IProveedor ProveedorClass(BaseDatos obj);
    public IParametro ParametroClass(BaseDatos obj);
    public IVenta VentaClass(BaseDatos obj);
    public IDetalleProducto DetalleProductoClass(BaseDatos obj);
    public IDetalleVenta DetalleVentaClass(BaseDatos obj);
    public IProducto ProductoClass(BaseDatos obj);
    public IOrdenCompra OrdenCompraClass(BaseDatos obj);
            
}
