/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import Type.BaseDatos;

/**
 *
 * @author Jesús
 */
public class LoginBO {
    LoginDAO Dao;
    LoginDTO Dto;
    public LoginBO(BaseDatos obj){
        Dao = new LoginDAO(obj);
    }
    public int Logear(String Usuario,String Password,String tipo){
        Dto = new LoginDTO(Usuario, Password, tipo);
        int estado=Dao.Login(Dto);
        return estado;
    }
}
