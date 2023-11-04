package DaoAdministrador;

import Conector.IConector;
import DataTransferObject.ProveedorDTO;
import Implementacion.BDFactory;
import Interfaces.IProveedor;
import Type.BaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class ProveedorA implements IProveedor<ProveedorDTO>{
    private final IConector conexion;
    private PreparedStatement ps;
    private ResultSet resp;
    
    public ProveedorA(BaseDatos obj) {
        this.conexion = BDFactory.getBaseDatos(obj);
    }

    @Override
    public void Ordenar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProveedorDTO> listar() {
        List<ProveedorDTO> lista = new ArrayList<>();
        try {
            ps = conexion.getConection().prepareStatement("SELECT* FROM ViewProveedor");
            resp = ps.executeQuery();
            while(resp.next()){
                lista.add(new ProveedorDTO(resp.getString(1),resp.getString(2),resp.getString(3),resp.getString(4)));
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("encontre un error");
            return null;
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
    }

    @Override
    public boolean agregar(ProveedorDTO obj) {
          try {
            ps = conexion.getConection().prepareStatement("{call InsertProveedor(?,?,?,?,?)}");
            ps.setString(1, obj.getIdProveedor());
            ps.setString(2, obj.getIdPersona());
            ps.setString(3, obj.getObservaciones());
            ps.setString(4, obj.getReferencias());
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
    public boolean actualizar(ProveedorDTO obj) {
           try {
            ps = conexion.getConection().prepareStatement("{call UpdateProveedor(?,?,?,?,?)}");
            ps.setString(1, obj.getIdProveedor());
            ps.setString(2, obj.getIdPersona());
            ps.setString(3, obj.getObservaciones());
              ps.setString(4, obj.getReferencias());
            ps.setBoolean(5, obj.isEstado());
            int r = ps.executeUpdate();
            while(r==1){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("no puedo actualizar el cliente");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return false;
    }

    @Override
    public boolean eliminar(String obj) {
         try {
            ps = conexion.getConection().prepareStatement("{call DeleteProveedor(?)}");
            ps.setString(1, obj);
            int r = ps.executeUpdate();
            while(r==1){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("no puedo eliminar el cliente");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return false;
    }

    @Override
    public ProveedorDTO buscar(ProveedorDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProveedorDTO Buscar2(String Id) {
          try {
            ps = conexion.getConection().prepareStatement("{call CompraProveedor (?)}");
            ps.setString(1, Id);
            resp = ps.executeQuery();
            while (resp.next()) {
                return new ProveedorDTO(resp.getString(1), resp.getString(2), resp.getString(3),resp.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("no lee la sentancia");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }

    @Override
    public List<ProveedorDTO> listarView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String Codigo(String text) {
         try {
            ps = conexion.getConection().prepareStatement("{call CodigoProveedor}");
            resp = ps.executeQuery();
            while(resp.next()){
                return resp.getInt(1)+"-"+text;
            }
        } catch (SQLException e) {
            System.out.println("no genera el codigo");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }
    
}
