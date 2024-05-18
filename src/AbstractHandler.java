abstract class AbstractHandler {
  protected AbstractHandler next;

  public void setNext(AbstractHandler next) {
    this.next = next;
  }

  public abstract void handle(SolicitudLogin request);
}
