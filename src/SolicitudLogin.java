class SolicitudLogin {
  private String usuario;
  private String contraseña;
  private String tipo;
  private String ipRequest;
  private Boolean validacion = false; // Atributo para manejar el bucle en el Cliente

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
  public Boolean getValidacion() {
    return validacion;
  }
  public void setValidacion(Boolean validacion) {
    this.validacion = validacion;
  }
}
