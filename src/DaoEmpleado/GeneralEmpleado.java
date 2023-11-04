package DaoEmpleado;

import Implementacion.IDaoGeneral;
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
public class GeneralEmpleado implements IDaoGeneral{

      @Override
    public IPersona PersonaClass(BaseDatos obj) {
        return new PersonaE(obj);
    }

    @Override
    public IUsuario UsuarioClass(BaseDatos obj) {
        return new UsuarioE(obj);
    }

    @Override
    public ICliente ClienteClass(BaseDatos obj) {
        return new ClienteE(obj);
    }

    @Override
    public IProveedor ProveedorClass(BaseDatos obj) {
        return new ProveedorE(obj);
    }

    @Override
    public IParametro ParametroClass(BaseDatos obj) {
        return new ParametroE(obj);
    }

    @Override
    public IVenta VentaClass(BaseDatos obj) {
        return new VentaE(obj);
    }

    @Override
    public IDetalleProducto DetalleProductoClass(BaseDatos obj) {
        return new DetalleProductoE(obj);
    }

    @Override
    public IDetalleVenta DetalleVentaClass(BaseDatos obj) {
        return new DetalleVentaE(obj);
    }

    @Override
    public IProducto ProductoClass(BaseDatos obj) {
        return new ProductoE(obj);
    }

    @Override
    public IOrdenCompra OrdenCompraClass(BaseDatos obj) {
        return new OrdenCompraE(obj);
    }
    
}
