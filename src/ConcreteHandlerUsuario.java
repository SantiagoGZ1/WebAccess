import java.util.ArrayList;
import java.util.List;

class ConcreteHandlerUsuario extends AbstractHandler {
  private List<Usuario> usuariosValidos;

  public ConcreteHandlerUsuario() {
    usuariosValidos = new ArrayList<>();
    // UsuariosGuardados
    usuariosValidos.add(new Usuario("user1", "password1", "usuario"));
  }

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