class ConcreteHandlerAdmin extends AbstractHandler {
  @Override
  public void handle(SolicitudLogin request) {
    if ("admin".equals(request.getTipo())) {
        System.out.println("Manejando inicio de sesión de administrador.");

        // Lógica de inicio de sesión de administrado
    } else if (next != null) {
      next.handle(request);
    }
  }
}
