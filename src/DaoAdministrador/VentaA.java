package DaoAdministrador;

import Conector.IConector;
import DataTransferObject.VentaEntity;
import Implementacion.BDFactory;
import Interfaces.IVenta;
import Type.BaseDatos;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class VentaA implements IVenta<VentaEntity>{
    private final IConector conexion;
    private PreparedStatement ps;
    private ResultSet resp;
    
   public  VentaA(BaseDatos obj) {
       this.conexion = BDFactory.getBaseDatos(obj);
   }

    @Override
    public void Ordenar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VentaEntity> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregar(VentaEntity obj) {
        try {
            ps = conexion.getConection().prepareStatement("{call InsertVenta(?,?,?,?,?,?,?,?)}");
            ps.setString(1, obj.getIdVenta());
            ps.setString(2, obj.getIdUsuario());
            ps.setString(3,obj.getIdCliente());
            ps.setDate(4, obj.getFecha());
            ps.setString(5, obj.getTipoComprovante());
            ps.setFloat(6, obj.getMontoTotal());
            ps.setFloat(7, obj.getImpuestos());
            ps.setBoolean(8, obj.isEstado());
            
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
    public boolean actualizar(VentaEntity obj) {
           try {
            ps = conexion.getConection().prepareStatement("{call UpdateVenta(?,?,?,?,?,?,?,?)}");
            ps.setString(1, obj.getIdVenta());
            ps.setString(2, obj.getIdUsuario());
            ps.setString(3,obj.getIdCliente());
            ps.setDate(4, obj.getFecha());
            ps.setString(5,obj.getTipoComprovante());
            ps.setFloat(6,obj.getMontoTotal());
            ps.setFloat(7, obj.getImpuestos());
            ps.setBoolean(8, true);
            
            int r = ps.executeUpdate();
            while (r == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("no puedo actualizar :(");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return false;
    }

    @Override
    public boolean eliminar(VentaEntity obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public VentaEntity buscar(VentaEntity obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VentaEntity> Buscar2(VentaEntity obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VentaEntity> listarView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String Codigo() {
        try {
            ps = conexion.getConection().prepareStatement("{call CodigoVenta}");
            resp = ps.executeQuery();
            while(resp.next()){
                return "DyE_Venta_"+resp.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("no genera el codigo");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }
    
}
