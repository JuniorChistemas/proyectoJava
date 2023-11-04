package DataTransferObject;
import Interfaces.IBuilder;
/**
 *
 * @author Jesús
 */
public class UsuarioDTO {
    private String IdUsuario;
    private String IdPersona;
    private float Sueldo;
    private String Password;
    private String nivel;
    private String IdParametro;
    private boolean Estado;
    private String EstadoTxt;
    
    public UsuarioDTO(){     
    }

    public UsuarioDTO(String IdUsuario, String IdPersona, float Sueldo, String Password, String IdParametro, boolean Estado) {
        this.IdUsuario = IdUsuario;
        this.IdPersona = IdPersona;
        this.Sueldo = Sueldo;
        this.Password = Password;
        this.IdParametro = IdParametro;
        this.Estado = Estado;
    }

    public UsuarioDTO(String IdUsuario, String IdPersona, float Sueldo, String nivel,String Estado) {
        this.IdUsuario = IdUsuario;
        this.IdPersona = IdPersona;
        this.Sueldo = Sueldo;
        this.nivel = nivel;
        this.EstadoTxt = Estado;
    }

    public UsuarioDTO(float Sueldo, String Password, String IdParametro, boolean Estado) {
        this.Sueldo = Sueldo;
        this.Password = Password;
        this.IdParametro = IdParametro;
        this.Estado = Estado;
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(String IdPersona) {
        this.IdPersona = IdPersona;
    }

    public float getSueldo() {
        return Sueldo;
    }

    public void setSueldo(float Sueldo) {
        this.Sueldo = Sueldo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getIdParametro() {
        return IdParametro;
    }

    public void setIdParametro(String IdParametro) {
        this.IdParametro = IdParametro;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public String getEstadoTxt() {
        return EstadoTxt;
    }

    public void setEstadoTxt(String EstadoTxt) {
        this.EstadoTxt = EstadoTxt;
    }
    
    public static class UsuarioBuilder implements IBuilder<UsuarioDTO>{
        private String IdUsuario;
        private String IdPersona;
        private float Sueldo;
        private String Password;
        private String nivel;
        private String IdParametro;
        private boolean Estado;
        private String EstadoTxt;
        
        public UsuarioBuilder(){
            
        }
        public UsuarioBuilder setIdUsuario(String IdUsuario){
            this.IdUsuario = IdUsuario;
            return this;
        }
         public UsuarioBuilder setIdPersona(String IdPersona){
             this.IdPersona = IdPersona;
             return this;
         }
          public UsuarioBuilder setSueldo(float Sueldo){
              this.Sueldo = Sueldo;
              return this;
          }
           public UsuarioBuilder setPassword(String Password){
               this.Password = Password;
               return this;
           }
            public UsuarioBuilder setNivel(String Nivel){
                this.nivel = Nivel;
                return this;
            }
             public UsuarioBuilder setIdParametro(String IdParametro){
                 this.IdParametro = IdParametro;
                 return this;
             }
             public UsuarioBuilder IsEstado(boolean Estado){
                 this.Estado = Estado;
                 return this;
             }
              public UsuarioBuilder setEstado(String Estado){
                  this.EstadoTxt = Estado;
                  return this;
              }
        @Override
        public UsuarioDTO build() {
            return new UsuarioDTO(IdUsuario, IdPersona, Sueldo, Password, IdParametro, Estado);
        }

        @Override
        public UsuarioDTO buildView() {
            return new UsuarioDTO(IdUsuario, IdPersona, Sueldo, nivel, EstadoTxt);
        }

        @Override
        public UsuarioDTO buildBuscar() {
            return new UsuarioDTO(Sueldo, Password, IdParametro, Estado);
        }
    }
    
}
