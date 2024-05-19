class ConcreteHandlerUsuario extends AbstractHandler {

  @Override
  public boolean handle(SolicitudLogin request) {
    if ("usuario".equals(request.getTipo())) {
      System.out.println("Manejando inicio de sesión de usuario común.");
      return true;
      // Lógica de inicio de sesión de usuario común
    } else {
      return true;
    }
  }
}