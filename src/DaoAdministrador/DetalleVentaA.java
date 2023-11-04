package DaoAdministrador;

import Conector.IConector;
import DataTransferObject.DetalleVentaDTO;
import Implementacion.BDFactory;
import Interfaces.IDetalleVenta;
import Type.BaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class DetalleVentaA implements IDetalleVenta<DetalleVentaDTO>{
    private final IConector conexion;
    private PreparedStatement ps;
    private ResultSet resp;
    public DetalleVentaA(BaseDatos obj) {
        this.conexion = BDFactory.getBaseDatos(obj);
    }

    @Override
    public List<DetalleVentaDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregar(DetalleVentaDTO obj) {
             try {
            ps = conexion.getConection().prepareStatement("{call InsertDetalleVenta(?,?,?,?,?)}");
            ps.setString(1, obj.getIdVenta());
            ps.setString(2, obj.getIdProducto());
            ps.setInt(3, obj.getCantidad());
            ps.setFloat(4, obj.getDescuento());
            ps.setFloat(5, obj.getPrecioUnitario()); //este dato funcionara como el importe total
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
    public boolean actualizar(DetalleVentaDTO obj) {
        return false;
    }

    @Override
    public boolean eliminar(DetalleVentaDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetalleVentaDTO buscar(DetalleVentaDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DetalleVentaDTO> Buscar2(DetalleVentaDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DetalleVentaDTO> listarView(String Venta) {
                List<DetalleVentaDTO> lista = new ArrayList<>();
        try {
            ps = conexion.getConection().prepareStatement("{ call ViewDetalleVenta2 (?)}");
            ps.setString(1, Venta);
            resp = ps.executeQuery();
            while(resp.next()){
                lista.add(new DetalleVentaDTO(resp.getString(1), resp.getString(2), resp.getInt(3), resp.getFloat(4), resp.getFloat(5))); 
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
