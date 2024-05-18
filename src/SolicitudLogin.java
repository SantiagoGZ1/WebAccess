class SolicitudLogin {
  private String usuario;
  private String contraseña;
  private String tipo;

  public SolicitudLogin(String usuario, String contraseña, String tipo) {
    this.usuario = usuario;
    this.contraseña = contraseña;
    this.tipo = tipo;
  }

  public String getUsuario() { return usuario; }
  public String getContraseña() { return contraseña; }
  public String getTipo() { return tipo; }
}

