abstract class AbstractHandler {
  protected AbstractHandler next;

  public void setNext(AbstractHandler next) {
    this.next = next;
  }

  public void handleRequest(SolicitudLogin request) {
    if (handle(request)) {
      if (next != null) {
        next.handleRequest(request);
      }
    }
  }

  public abstract boolean handle(SolicitudLogin request);
}
