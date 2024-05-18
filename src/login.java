import java.util.Scanner;

public class login extends AbstractHandler {

  @Override
  public void handle(SolicitudLogin request) {
    Scanner credencial = new Scanner(System.in);
    //preguntar datos
    System.out.println("Ingresa el nombre de usuario");
    String nombreUsuario = credencial.nextLine();

    System.out.println("Ingrese la contraseña");
    String contraseña = credencial.nextLine();

    System.out.println("Ingrese el tipo de usuario (usuario/admin)");
    String tipo = credencial.nextLine();
    //----

    int contadorError = 0;  // Inicializar contadorError fuera del bucle
    do {
      if (nombreUsuario.equals(request.getUsuario()) && contraseña.equals(request.getContraseña()) && "user".equals(request.getTipo())) {
        System.out.println("BIENVENIDO USUARIO");
        contadorError = 5;

      } else if (nombreUsuario.equals(request.getUsuario()) && contraseña.equals(request.getContraseña()) && "admin".equals(request.getTipo())) {
        System.out.println("BIENVENIDO ADMIN");
        contadorError = 5;

      } else {
        contadorError = 0;
        contadorError++;  // Incrementar contadorError sin restablecerlo a 0
        System.out.println("Intentos fallidos : (" + contadorError + "/5)");
      }
    } while (contadorError < 5);
  }

}
