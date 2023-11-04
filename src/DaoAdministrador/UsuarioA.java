package DaoAdministrador;

import Conector.IConector;
import DataTransferObject.UsuarioDTO;
import Implementacion.BDFactory;
import Interfaces.IUsuario;
import Type.BaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class UsuarioA implements IUsuario<UsuarioDTO>{
    private final IConector conexion;
    private PreparedStatement ps;
    private ResultSet resp;
    
    public UsuarioA(BaseDatos obj) {
        this.conexion = BDFactory.getBaseDatos(obj);
    }

    @Override
    public void Ordenar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UsuarioDTO> listar() {
        List<UsuarioDTO> lista = new ArrayList<>();
        try {
            ps = conexion.getConection().prepareStatement("SELECT* FROM ViewUsuario");
            resp = ps.executeQuery();
            while(resp.next()){
                lista.add(new UsuarioDTO.UsuarioBuilder().setIdUsuario(resp.getString(1).trim()).setIdPersona(resp.getString(2).trim()).setNivel(resp.getString(3).trim()).setSueldo(resp.getFloat(4)).setEstado(resp.getString(5).trim()).buildView());
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("error no se puede listar");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }

    @Override
    public boolean agregar(UsuarioDTO obj) {
        try {
            ps =  conexion.getConection().prepareStatement("{call InsertUsuario(?,?,?,?,?,?)}");
            ps.setString(1, obj.getIdUsuario());
            ps.setString(2, obj.getIdPersona());
            ps.setFloat(3, obj.getSueldo());
            ps.setString(4, obj.getPassword());
            ps.setString(5, obj.getIdParametro());
            ps.setBoolean(6, obj.isEstado());
            int r = ps.executeUpdate();
            while(r==1){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("no puedo agregar el usuario");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return false;
    }

    @Override
    public boolean actualizar(UsuarioDTO obj) {
               try {
            ps =  conexion.getConection().prepareStatement("{call UpdateUsuario(?,?,?,?,?)}");
            ps.setString(1, obj.getIdUsuario());
            ps.setFloat(2, obj.getSueldo());
            ps.setString(3, obj.getPassword());
            ps.setString(4, obj.getIdParametro());
            ps.setBoolean(5, obj.isEstado());
            int r = ps.executeUpdate();
            while(r==1){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("no puedo Actualizar el usuario");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return false;
    }

    @Override
    public boolean eliminar(String obj) {
        try {
            ps = conexion.getConection().prepareStatement("{call Delete_Usuario(?)}");
            ps.setString(1, obj);
            int r= ps.executeUpdate();
            while(r==1){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("no puedo eliminar el usuario");
        } finally {
             conexion.CerrarConection(conexion.getConection());
        }
        return false;
    }

    @Override
    public UsuarioDTO buscar(String obj) {
        try {
            ps = conexion.getConection().prepareStatement("{call BuscarUsuario(?)}");
            ps.setString(1, obj);
            resp = ps.executeQuery();
            while(resp.next()){
                return new UsuarioDTO.UsuarioBuilder().setSueldo(resp.getFloat(1)).setPassword(resp.getString(2)).setIdParametro(resp.getString(3)).IsEstado(resp.getBoolean(4)).buildBuscar();
            }
        } catch (SQLException e) {
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }

    @Override
    public UsuarioDTO Buscar2(String obj) {
          try {
            ps = conexion.getConection().prepareStatement("{call VentaUsuario (?)}");
            ps.setString(1, obj);
            resp = ps.executeQuery();
            while (resp.next()) {
                return new UsuarioDTO(resp.getString(1), resp.getString(2),0, resp.getString(3).trim(),resp.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("no lee la sentancia");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }
//no lo vamos a implementar............
    @Override
    public List<UsuarioDTO> listarView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String Codigo() {
        try {
            ps = conexion.getConection().prepareStatement("{call CodigoUsuario}");
            resp = ps.executeQuery();
            while(resp.next()){
                return "User_"+resp.getInt(1)+"A";
            }
        } catch (SQLException e) {
                System.out.println("no genera el codigo");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }
    
}
