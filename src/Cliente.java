import java.util.Scanner;

public class Cliente {
  public static void main(String[] args) {

    AbstractHandler usuarioHandler = new ConcreteHandlerUsuario();
    AbstractHandler adminHandler = new ConcreteHandlerAdmin();
    ConcreteHandlerInvalid invalidUser = new ConcreteHandlerInvalid();
    AbstractHandler cacheUser = new ConcreteHandleCache();
    AbstractHandler sistemaOrdenes = new SistemaDeOrdenes();
    GeneradorIp random = new GeneradorIp();
    String ip = random.guardarIp();

    //Cadena de responsabilidad
    invalidUser.setNext(usuarioHandler);
    usuarioHandler.setNext(adminHandler);
    adminHandler.setNext(cacheUser);
    cacheUser.setNext(sistemaOrdenes);

    Scanner scanner = new Scanner(System.in);

    boolean autenticado = false;
    while (!autenticado) {
      System.out.print("Ingrese el nombre de usuario: ");
      String usuario = scanner.nextLine();
      System.out.print("Ingrese la contraseña: ");
      String contrasenia = scanner.nextLine();
      System.out.print("Ingrese el tipo de usuario (usuario/admin): ");
      String tipo = scanner.nextLine();

      SolicitudLogin solicitud = new SolicitudLogin(usuario, contrasenia, tipo, ip);

      invalidUser.handleRequest(solicitud);
      autenticado = solicitud.getValidacion();

      if (invalidUser.isIpBlocked(ip)) {
        System.out.println("La IP ha sido bloqueada. No puede intentar más.");
        break;
      }
    }
  }
}
