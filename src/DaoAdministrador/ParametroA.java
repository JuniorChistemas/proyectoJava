package DaoAdministrador;

import Conector.IConector;
import DataTransferObject.ParametroDTO;
import Implementacion.BDFactory;
import Interfaces.IParametro;
import Type.BaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class ParametroA implements IParametro<ParametroDTO>{
    private final IConector conexion;
    private PreparedStatement ps;
    private ResultSet resp;
    
    public ParametroA(BaseDatos obj) {
        this.conexion = BDFactory.getBaseDatos(obj);
    }

    @Override
    public List<ParametroDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregar(ParametroDTO obj) {
         try {
            ps = conexion.getConection().prepareStatement("{call InsertParametro(?,?,?,?)}");
            ps.setString(1, obj.getIdParamero());
            ps.setString(2, obj.getDescripcion());
            ps.setString(3,obj.getTipo());
            ps.setBoolean(4, obj.isEstado());
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
    public boolean actualizar(ParametroDTO obj) {
        try {
            ps = conexion.getConection().prepareStatement("{call UpdateParametro(?,?,?,?)}");
            ps.setString(1, obj.getIdParamero());
            ps.setString(2, obj.getDescripcion());
            ps.setString(3, obj.getTipo());
            ps.setBoolean(4, obj.isEstado());
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
    public boolean eliminar(String obj) {
        try {
            ps = conexion.getConection().prepareStatement("{call DeleteParametro(?)}");
            ps.setString(1, obj);
            int r = ps.executeUpdate();
            while (r == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("no se elimino");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return false;
    }

    @Override
    public ParametroDTO buscar(String obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ParametroDTO> Buscar2(ParametroDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ParametroDTO> listarView() {
        List<ParametroDTO> lista = new ArrayList<>();
        try {
            ps = conexion.getConection().prepareStatement("SELECT* FROM Parametro_View");
            resp = ps.executeQuery();
            while(resp.next()){
                lista.add(new ParametroDTO.ParametroBuilder().setIdParametro(resp.getString(1)).setDescripcion(resp.getString(2)).setTipo(resp.getString(3)).setEstadoText(resp.getString(4)).buildView());
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("no me retorna la lista");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }

    @Override
    public String Codigo() {
          try {
            ps = conexion.getConection().prepareStatement("{call CodigoParametro}");
            resp = ps.executeQuery();
            while(resp.next()){
                return "DyE_Parametro"+resp.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("no genera el codigo");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }

    @Override
    public List<ParametroDTO> Categoria() {
        List<ParametroDTO> lista = new ArrayList<>();
         try {
            ps = conexion.getConection().prepareStatement("SELECT* FROM ListarCategoria");
            resp = ps.executeQuery();
            while(resp.next()){
                lista.add(new ParametroDTO.ParametroBuilder().setIdParametro(resp.getString(1)).setDescripcion(resp.getString(2)).setTipo(resp.getString(3)).setEstadoText(resp.getString(4)).buildView());
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("no me retorna la lista");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }

    @Override
    public List<ParametroDTO> Marca() {
      List<ParametroDTO> lista = new ArrayList<>();
         try {
            ps = conexion.getConection().prepareStatement("SELECT* FROM ListarMarca");
            resp = ps.executeQuery();
            while(resp.next()){
                lista.add(new ParametroDTO.ParametroBuilder().setIdParametro(resp.getString(1)).setDescripcion(resp.getString(2)).setTipo(resp.getString(3)).setEstadoText(resp.getString(4)).buildView());
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
