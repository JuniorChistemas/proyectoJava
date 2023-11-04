package DaoEmpleado;

import Conector.IConector;
import DataTransferObject.PersonaDTO;
import DataTransferObject.PersonaEntity;
import Implementacion.BDFactory;
import Interfaces.IPersona;
import Type.BaseDatos;
import java.sql.*;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Jesús
 */
public class PersonaE implements IPersona<PersonaEntity,PersonaDTO>{
    private final IConector conexion;
    private PreparedStatement ps;
    private ResultSet resp;
    
    public PersonaE(BaseDatos obj) {
        this.conexion = BDFactory.getBaseDatos(obj);
    }

    @Override
    public List<PersonaDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregar(PersonaEntity obj) {
           try {
            ps = conexion.getConection().prepareStatement("{call InsertPersona (?,?,?,?,?,?,?,?,?,?,?) }");
            ps.setString(1,obj.getIdPersona());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getApellido());
            ps.setString(4, obj.getNumeroDucumento());
            ps.setString(5, obj.getCelular());
            ps.setString(6, obj.getCorreo());
            ps.setBoolean(7, obj.isGenero());
            ps.setDate(8, obj.getFechaNac());
            ps.setString(9, obj.getDireccion());
            ps.setString(10, obj.getIdParametro());
            ps.setBoolean(11, obj.isEstado());
         int r = ps.executeUpdate();
         while(r==1){
             return true;
         }
        } catch (SQLException e) {
            System.out.println("no puedo agregar :(");
        }finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return false;
    }

    @Override
    public boolean actualizar(PersonaEntity obj) {
         try {
            ps = conexion.getConection().prepareStatement("{call UpdatePersona (?,?,?,?,?,?,?,?,?,?,?) }");
            ps.setString(1,obj.getIdPersona());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getApellido());
            ps.setString(4, obj.getNumeroDucumento());
            ps.setString(5, obj.getCelular());
            ps.setString(6, obj.getCorreo());
            ps.setBoolean(7, obj.isGenero());
            ps.setDate(8, obj.getFechaNac());
            ps.setString(9, obj.getDireccion());
            ps.setString(10, obj.getIdParametro());
            ps.setBoolean(11, obj.isEstado());
         int r = ps.executeUpdate();
         while(r==1){
             return true;
         }
        } catch (SQLException e) {
            System.out.println("no puedo actualizar :(");
        }finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return false;
    }

    @Override
    public boolean eliminar(String obj) {
        return false;
    }

    @Override
    public PersonaEntity buscar(String obj) {
           try {
            ps = conexion.getConection().prepareCall("{call BuscarPersona (?)}");
            ps.setString(1, obj);
            resp = ps.executeQuery();
            while (resp.next()) {
                System.out.println("Ingrese al bucle");
                return (new PersonaEntity(resp.getString(1).trim(), resp.getString(2).trim(), resp.getString(3).trim(), resp.getString(4).trim(), 
                        resp.getString(5).trim(), resp.getString(6).trim(),resp.getBoolean(7), resp.getDate(8), resp.getString(9).trim(), resp.getString(10).trim(),resp.getBoolean(11)));
            }
        } catch (SQLException e) {
                System.out.println("no ahy nada");
        } finally {
                conexion.CerrarConection(conexion.getConection());
        }
            return null;
    }

    @Override
    public PersonaEntity Buscar2(String obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PersonaDTO> listarView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String Codigo() {
        try {
            ps = conexion.getConection().prepareStatement("{call CodigoPersona}");
            resp = ps.executeQuery();
            while(resp.next()){
                return "DyE_P"+resp.getInt(1)+"_"+this.numero();
            }
        } catch (SQLException e) {
            System.out.println("no genera el codigo");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return null;
    }
        private int numero(){
        Random n = new Random();
        return (int)(n.nextDouble()*99999);
    }
    
}
