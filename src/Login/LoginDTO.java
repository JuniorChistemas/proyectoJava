package Login;

/**
 *
 * @author Jesús
 */
public class LoginDTO {
    private String Usuario;
    private String Password;
    private String Nivel;

    public LoginDTO() {
    }

    public LoginDTO(String Usuario, String Password, String Nivel) {
        this.Usuario = Usuario;
        this.Password = Password;
        this.Nivel = Nivel;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String Nivel) {
        this.Nivel = Nivel;
    }
}
