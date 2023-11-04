package DaoEmpleado;

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
public class UsuarioE implements IUsuario<UsuarioDTO>{
    private final IConector conexion;
    private PreparedStatement ps;
    private ResultSet resp;
    
    public UsuarioE(BaseDatos obj) {
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
                lista.add(new UsuarioDTO.UsuarioBuilder().setIdUsuario(resp.getString(1).trim()).setIdPersona(resp.getString(2).trim()).setNivel(resp.getString(3).trim()).setSueldo(0.00f).setEstado(resp.getString(5).trim()).buildView());
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
        return false;
    }

    @Override
    public boolean actualizar(UsuarioDTO obj) {
        return false;
    }

    @Override
    public boolean eliminar(String obj) {
        return false;
    }

    @Override
    public UsuarioDTO buscar(String obj) {
          try {
            ps = conexion.getConection().prepareStatement("{call BuscarUsuario(?)}");
            ps.setString(1, obj);
            resp = ps.executeQuery();
            while(resp.next()){
                return new UsuarioDTO.UsuarioBuilder().setSueldo(0.00f).setPassword("******").setIdParametro(resp.getString(3)).IsEstado(resp.getBoolean(4)).buildBuscar();
            }
        } catch (SQLException e) {
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }

    @Override
    public UsuarioDTO Buscar2  (String obj) {
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
                return "User_"+resp.getInt(1)+"E";
            }
        } catch (SQLException e) {
                System.out.println("no genera el codigo");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }
    
}
