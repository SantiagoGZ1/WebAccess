class SolicitudLogin {
  private String usuario;
  private String contraseña;
  private String tipo;
  private String ipRequest;

  public SolicitudLogin(String usuario, String contraseña, String tipo, String ipRequest) {
    this.usuario = usuario;
    this.contraseña = contraseña;
    this.tipo = tipo;
    this.ipRequest = ipRequest;
  }

  public String getUsuario() { return usuario; }
  public String getContraseña() { return contraseña; }
  public String getTipo() { return tipo; }
  public String getIpRequest() { return ipRequest; }
}
