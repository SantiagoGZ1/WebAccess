import java.util.Scanner;

public class Cliente {
  public static void main(String[] args) {
    Scanner credencial = new Scanner(System.in);

    AbstractHandler usuarioHandler = new ConcreteHandlerUsuario();
    AbstractHandler adminHandler = new ConcreteHandlerAdmin();
    AbstractHandler invalidUser = new ConcreteHandlerInvalid();
    AbstractHandler cacheUser = new ConcreteHandleCache();
    AbstractHandler data = new login();
    GeneradorIp random = new GeneradorIp();


    usuarioHandler.setNext(adminHandler);
    adminHandler.setNext(cacheUser);
    cacheUser.setNext(invalidUser);


    SolicitudLogin solicitudUsuario = new SolicitudLogin("user1", "password1", "usuario");
    SolicitudLogin solicitudAdmin = new SolicitudLogin("admin1", "adminpass", "admin");

    data.handle(solicitudAdmin);
  }
}
