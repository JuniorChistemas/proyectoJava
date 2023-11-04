package DaoAdministrador;

import Conector.IConector;
import DataTransferObject.ClienteDTO;
import DataTransferObject.ClienteEntity;
import DataTransferObject.ClienteView;
import Implementacion.BDFactory;
import Interfaces.ICliente;
import Type.BaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class ClienteA implements ICliente<ClienteEntity,ClienteDTO>{
    private final IConector conexion;
    private PreparedStatement ps;
    private ResultSet resp;
    public ClienteA(BaseDatos obj) {
        this.conexion = BDFactory.getBaseDatos(obj);
    }

    @Override
    public List<ClienteDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean agregar(ClienteEntity obj) {
        try {
            ps = conexion.getConection().prepareStatement("{call InsertCliente(?,?,?,?,?)}");
            ps.setString(1, obj.getIdCliente());
            ps.setString(2, obj.getIdPersona());
            ps.setDate(3,obj.getFechaI());
            ps.setString(4, obj.getObservaciones());
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
    public boolean actualizar(ClienteEntity obj) {
        try {
            ps = conexion.getConection().prepareStatement("{call UpdateCliente(?,?,?,?)}");
            ps.setString(1, obj.getIdCliente());
            ps.setDate(2, obj.getFechaI());
            ps.setString(3, obj.getObservaciones());
            ps.setBoolean(4, obj.isEstado());
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
            ps = conexion.getConection().prepareStatement("{call DeleteCliente(?)}");
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
    public ClienteEntity buscar(String IdCliente) {
        try {
            ps = conexion.getConection().prepareStatement("{call BuscarCliente (?)}");
            ps.setString(1, IdCliente);
            resp = ps.executeQuery();
            while (resp.next()) {
                return new ClienteEntity(resp.getString(1), resp.getString(2), resp.getDate(3), resp.getString(4).trim(),resp.getBoolean(5));
            }
        } catch (SQLException e) {
            System.out.println("no lee la sentancia");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }

    @Override
    public ClienteDTO Buscar2(String obj) {
        /**
         * lo que va a hacer es almacenar momentaneamente los datos que se estraer 
         */  
        try {
            ps = conexion.getConection().prepareStatement("{call VentaCliente (?)}");
            ps.setString(1, obj);
            resp = ps.executeQuery();
            while (resp.next()) {
                return new ClienteDTO(resp.getString(1), resp.getString(2), null, resp.getString(3).trim(),resp.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("no lee la sentancia");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }

    @Override
    public List<ClienteDTO> listarView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     @Override
    public List<ClienteView> listarDatos(){
        List<ClienteView> lista = new ArrayList<>();
        try {
            ps = conexion.getConection().prepareStatement("SELECT* FROM Cliente_View");
            resp = ps.executeQuery();
            while(resp.next()){
                lista.add(new ClienteView(resp.getString(1),resp.getString(2),resp.getString(3),resp.getString(4),resp.getString(5),null,null));
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
    }

    @Override
    public String Codigo(String tex) {
        try {
            ps = conexion.getConection().prepareStatement("{call CodigoCliente}");
            resp = ps.executeQuery();
            while(resp.next()){
                return resp.getInt(1)+"-"+tex+"A";
            }
        } catch (SQLException e) {
            System.out.println("no genera el codigo");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }
    
}
