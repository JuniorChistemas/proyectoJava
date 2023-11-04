
package Login;

import Conector.IConector;
import Implementacion.BDFactory;
import Type.BaseDatos;
import java.sql.*;

/**
 *
 * @author Jesús
 */
public class LoginDAO implements ILogin<LoginDTO>{
    private final IConector conexion;
    private CallableStatement ps;

    public LoginDAO(BaseDatos obj) {
        this.conexion = BDFactory.getBaseDatos(obj);
    }
    @Override
    public int Login(LoginDTO obj) {
        try {
            ps = conexion.getConection().prepareCall("{call Logeo(?,?,?,?)}");
            ps.setString(1, obj.getUsuario());
            ps.setString(2, obj.getPassword());
            ps.setString(3, obj.getNivel());
            ps.registerOutParameter(4, java.sql.Types.INTEGER);
            ps.execute();
               return ps.getInt(4);
        } catch (SQLException e) {
            System.out.println("no lo lee");
        }finally{
            conexion.CerrarConection(conexion.getConection());
        }
        return 0;
    }
}
