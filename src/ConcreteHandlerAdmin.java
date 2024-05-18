import java.util.ArrayList;
import java.util.List;

class ConcreteHandlerAdmin extends AbstractHandler {
  private List<Usuario> adminValidos;

  public ConcreteHandlerAdmin() {
    adminValidos = new ArrayList<>();
    // AdminsGuardados
    adminValidos.add(new Usuario("admin1", "adminpass", "admin"));
  }

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
