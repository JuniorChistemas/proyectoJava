package DaoAdministrador;

import Conector.IConector;
import DataTransferObject.ProductoDTO;
import Implementacion.BDFactory;
import Interfaces.IProducto;
import Type.BaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Jesús
 */
public class ProductoA implements IProducto<ProductoDTO>{
    private final IConector conexion;
    private PreparedStatement ps;
    private ResultSet resp;
    
    public ProductoA(BaseDatos obj) {
        this.conexion = BDFactory.getBaseDatos(obj);
    }

    @Override
    public List<ProductoDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregar(ProductoDTO obj) {
        try {
            ps = conexion.getConection().prepareStatement("{call InsertProducto(?,?,?,?,?,?)}");
            ps.setString(1, obj.getIdProducto());
            ps.setString(2, obj.getNombre());
            ps.setBoolean(3, obj.isEstado());
            ps.setInt(4, obj.getStock());
            ps.setFloat(5, obj.getPrecioV());
            ps.setString(6, obj.getIdParametro());
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
    public boolean actualizar(ProductoDTO obj) {
              try {
            ps = conexion.getConection().prepareStatement("{call UpdateProducto(?,?,?,?,?)}");
            ps.setString(1, obj.getIdProducto());
            ps.setString(2, obj.getNombre());
            ps.setBoolean(3, obj.isEstado());
            ps.setInt(4, obj.getStock());
            ps.setFloat(5, obj.getPrecioV());
            int r = ps.executeUpdate();
            while (r == 1) {
                System.out.println("ingreso aqui");
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
    public boolean eliminar(String obj) {
          try {
            ps = conexion.getConection().prepareStatement("{call DeleteProducto(?)}");
            ps.setString(1, obj);
            int r = ps.executeUpdate();
            while (r == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("datos no eliminados");
        } finally {
            conexion.CerrarConection(conexion.getConection());
        }
        return false;
    }

    @Override
    public ProductoDTO buscar(String obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProductoDTO> Buscar2(String obj) {
         List<ProductoDTO> lista = new ArrayList<>();
        try {
            ps = conexion.getConection().prepareStatement("SELECT* FROM ProductosVenta");
            resp = ps.executeQuery();
            while(resp.next()){
                lista.add(new ProductoDTO.ProductoBuilder().setIdProducto(resp.getString(1)).setNombre(resp.getString(2)).setStock(resp.getInt(3)).setPrecioV(resp.getFloat(4)).buildBuscar());
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
    public List<ProductoDTO> listarView() {
        List<ProductoDTO> lista = new ArrayList<>();
        try {
            ps = conexion.getConection().prepareStatement("SELECT* FROM ViewProducto");
            resp = ps.executeQuery();
            while(resp.next()){
                lista.add(new ProductoDTO.ProductoBuilder().setIdProducto(resp.getString(1)).setNombre(resp.getString(2)).setIdParametro(resp.getString(3)).setEstadoTxt(resp.getString(4)).setStock(resp.getInt(5)).setPrecioV(resp.getFloat(6)).buildView());
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
            ps = conexion.getConection().prepareStatement("{call CodigoProducto}");
            resp = ps.executeQuery();
            while(resp.next()){
                return "DyE_Pro"+resp.getInt(1)+"_"+this.numero();
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
