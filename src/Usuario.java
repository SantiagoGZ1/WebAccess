public class Usuario {
    private String nombre;
    private String contraseña;
    private String tipoDeUsuario; // usuario o admin

    public Usuario(String nombre, String contraseña, String tipoDeUsuario) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }
}

