package DaoAdministrador;

import Conector.IConector;
import DataTransferObject.DetalleProductoDTO;
import Implementacion.BDFactory;
import Interfaces.IDetalleProducto;
import Type.BaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class DetalleProductoA implements IDetalleProducto<DetalleProductoDTO> {
    private final IConector conexion;
    private PreparedStatement ps;
    private ResultSet resp;
    
    public DetalleProductoA(BaseDatos obj) {
        this.conexion = BDFactory.getBaseDatos(obj);
    }

    @Override
    public List<DetalleProductoDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregar(DetalleProductoDTO obj) {
        try {
            ps = conexion.getConection().prepareStatement("{call InsertDetalleCompra(?,?,?,?,?)}");
            ps.setString(1, obj.getIdDeatelleProducto());
            ps.setString(2, obj.getIdProducto());
            ps.setInt(3, obj.getCantidad());
            ps.setFloat(4, obj.getPrecioComprar());
            ps.setFloat(5, obj.getTotal()); //este dato funcionara como el importe total
            int r = ps.executeUpdate();
            while (r == 1) {
                System.out.println("hola por aqui");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("no puedo agregar :(");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return false;
    }

    @Override
    public boolean actualizar(DetalleProductoDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(DetalleProductoDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetalleProductoDTO buscar(DetalleProductoDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DetalleProductoDTO> Buscar2(DetalleProductoDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DetalleProductoDTO> listarView(String Cod) {
                      List<DetalleProductoDTO> lista = new ArrayList<>();
        try {
            ps = conexion.getConection().prepareStatement("{ call ViewDetalleCompra2 (?)}");
            ps.setString(1, Cod);
            resp = ps.executeQuery();
            while(resp.next()){
                lista.add(new DetalleProductoDTO(resp.getString(1), resp.getString(2), resp.getInt(3), resp.getFloat(4), resp.getFloat(5))); 
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("no me retorna la lista");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }
    
}
