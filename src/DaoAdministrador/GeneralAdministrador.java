package DaoAdministrador;

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
public class GeneralAdministrador implements IDaoGeneral{

    @Override
    public IPersona PersonaClass(BaseDatos obj) {
        return new PersonaA(obj);
    }

    @Override
    public IUsuario UsuarioClass(BaseDatos obj) {
        return new UsuarioA(obj);
    }

    @Override
    public ICliente ClienteClass(BaseDatos obj) {
        return new ClienteA(obj);
    }

    @Override
    public IProveedor ProveedorClass(BaseDatos obj) {
        return new ProveedorA(obj);
    }

    @Override
    public IParametro ParametroClass(BaseDatos obj) {
        return new ParametroA(obj);
    }

    @Override
    public IVenta VentaClass(BaseDatos obj) {
        return new VentaA(obj);
    }

    @Override
    public IDetalleProducto DetalleProductoClass(BaseDatos obj) {
        return new DetalleProductoA(obj);
    }

    @Override
    public IDetalleVenta DetalleVentaClass(BaseDatos obj) {
        return new DetalleVentaA(obj);
    }

    @Override
    public IProducto ProductoClass(BaseDatos obj) {
        return new ProductoA(obj);
    }

    @Override
    public IOrdenCompra OrdenCompraClass(BaseDatos obj) {
        return new OrdenCompraA(obj);
    }
    
}
