package DaoAdministrador;

import Conector.IConector;
import DataTransferObject.OrdenCompraDTO;
import Implementacion.BDFactory;
import Interfaces.IOrdenCompra;
import Type.BaseDatos;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class OrdenCompraA implements IOrdenCompra<OrdenCompraDTO>{
    private final IConector conexion;
    private PreparedStatement ps;
    private ResultSet resp;
    
    public OrdenCompraA(BaseDatos obj) {
        this.conexion = BDFactory.getBaseDatos(obj);
    }

    @Override
    public List<OrdenCompraDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregar(OrdenCompraDTO obj) {
         try {
            ps = conexion.getConection().prepareStatement("{call InsertOrdenCompra(?,?,?,?,?)}");
            ps.setString(1, obj.getIdOrdenCompra());
            ps.setFloat(2, obj.getMontoT());
            ps.setString(3,obj.getIdProveedor());
            ps.setString(4, obj.getMarca());
            ps.setBoolean(5, obj.isEstado());
            
            int r = ps.executeUpdate();
            while (r == 1) {
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
    public boolean actualizar(OrdenCompraDTO obj) {
          try {
            ps = conexion.getConection().prepareStatement("{call UpdateOrdenCompra(?,?,?,?,?)}");
            ps.setString(1, obj.getIdOrdenCompra());
            ps.setFloat(2, obj.getMontoT());
            ps.setDate(3,  obj.getFecha());
            ps.setString(4,obj.getIdProveedor());
            ps.setBoolean(5, obj.isEstado());
            
            int r = ps.executeUpdate();
            while (r == 1) {
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
    public boolean eliminar(OrdenCompraDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OrdenCompraDTO buscar(OrdenCompraDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OrdenCompraDTO> Buscar2(OrdenCompraDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OrdenCompraDTO> listarView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String Codigo(String X) {
          try {
            ps = conexion.getConection().prepareStatement("{call CodigoOrden}");
            resp = ps.executeQuery();
            while(resp.next()){
                return "DyE_Orden_"+resp.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("no genera el codigo");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }

   
    
}
