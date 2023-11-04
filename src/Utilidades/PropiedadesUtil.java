package Utilidades;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Jesús
 */
public class PropiedadesUtil {
      public static Properties loadProperty(String url){
        try {
            Properties properties = new Properties();
            InputStream inputStream = PropiedadesUtil.class.getClassLoader().getResourceAsStream(url);
            properties.load(inputStream);
            return properties;            
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
}
