package Implementacion;

import Conector.IConector;
import Conector.SQLServer;
import Type.BaseDatos;

/**
 *
 * @author Jesús
 */
public class BDFactory {
    public static IConector getBaseDatos(BaseDatos obj){
        switch (obj) {
            case SQLServer-> {
                return new SQLServer();
            }
            case Mysql -> {
                return   null;
            }
        }  
        return null;
    }
}
