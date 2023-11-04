package Implementacion;

import Type.Nivel;

/**
 *
 * @author Jesús
 */
public class AbstractFactory {
    public static IDaoGeneral getClases(Nivel obj) {
        switch (obj) {
            case PaqueteAdministrador -> {
                System.out.println("\t************se inician clases para el administrador************");
                return new DaoAdministrador.GeneralAdministrador();
            }
            case PaqueteEmpleado -> {
                System.out.println("\t************se inician clases para el usuario************");
                return new DaoEmpleado.GeneralEmpleado();
            }
        }
        return null;
    }
}
