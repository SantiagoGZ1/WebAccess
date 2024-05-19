class ConcreteHandlerAdmin extends AbstractHandler {

  @Override
  public boolean handle(SolicitudLogin request) {
    if ("admin".equals(request.getTipo())) {
      System.out.println("Manejando inicio de sesión de usuario admin.");
      return true;
      // Lógica de inicio de sesión de usuario admin
    } else {
      return true;
    }
  }
}
