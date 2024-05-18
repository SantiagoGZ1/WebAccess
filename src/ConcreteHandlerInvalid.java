public class ConcreteHandlerInvalid extends AbstractHandler{

  @Override
  public void handle(SolicitudLogin request) {
    System.out.println("Tipo de usuario invalido: " + request.getTipo());
  }
}
