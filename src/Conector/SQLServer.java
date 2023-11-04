package Conector;

import Utilidades.PropiedadesUtil;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @author Jesús
 */
public class SQLServer implements IConector{
    private static final String ClasePropiedades = "DatosPropiedades/DatosSQL.properties";
    private static final String nombre = "dbname";
    private static final String hostName = "host";
    private static final String password1 = "password";
    private static final String numeroPuerto = "port";
    private static final String usuario = "user"; 
    
    Properties pro = PropiedadesUtil.loadProperty(ClasePropiedades);
    
    static{
        try {
            new com.microsoft.sqlserver.jdbc.SQLServerDriver();
        } catch (Exception e) {
            System.out.println("Error en el driver");
        }
    }
     private String createConnectionString() {
        String host = pro.getProperty(hostName);
        String port = pro.getProperty(numeroPuerto);
        String db = pro.getProperty(nombre);
        String connectionString = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + db;
        return connectionString;
    }

    @Override
    public Connection getConection() {
          try {
            String conexcion = createConnectionString();
            Connection connection =DriverManager.getConnection(conexcion, pro.getProperty(usuario),
                                                                                        pro.getProperty(password1));
            return connection;
        } catch (SQLException e) {
            System.out.println("no conecta");
            return null;
        }
    }

    @Override
    public void CerrarConection(Connection o) {
         if(o != null){
            try {
                if(o.isClosed()){
                    o.close();
                }
            } catch (SQLException e) {
                System.out.println("error"+e);
            }
        }
    }    
}
