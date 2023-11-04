package Conector;

import java.sql.*;

/**
 *
 * @author Jesús
 */
public interface IConector {
    public Connection getConection();
    public void CerrarConection(Connection o);  
}
