public class ConcreteHandleCache extends AbstractHandler{

  private String cacheUser;
  private String cacheTipo;

  @Override
  public boolean handle(SolicitudLogin request) {
      cacheUser = request.getUsuario();
      cacheTipo = request.getTipo();

      System.out.println("Último usuario que inició sesión: " + cacheUser + " con el rol: " + cacheTipo);
      return true;
  }
}
