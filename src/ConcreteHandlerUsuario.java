class ConcreteHandlerUsuario extends AbstractHandler {
  @Override
  public void handle(SolicitudLogin request) {
    if ("usuario".equals(request.getTipo())) {
      System.out.println("Manejando inicio de sesión de usuario común.");
      // Lógica de inicio de sesión de usuario común
    } else if (next != null) {
      next.handle(request);
    }
  }
}