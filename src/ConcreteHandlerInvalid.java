import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteHandlerInvalid extends AbstractHandler{
  private String[] ips;
  private int[] intentosFallidos;
  private static final int MAX_INTENTOS = 4;
  private static final String USUARIOS_FILE = "src/BaseDeDatos.txt";

  public ConcreteHandlerInvalid() {
    ips = new String[MAX_INTENTOS];
    intentosFallidos = new int[MAX_INTENTOS];
  }

  @Override
  public boolean handle(SolicitudLogin request) {
    String ip = request.getIpRequest();

    int index = -1;
    for (int i = 0; i < ips.length; i++) {
      if (ip.equals(ips[i])) {
        index = i;
        break;
      }
    }
    // Revisa que el usuario exista
    if (validarCredenciales(request.getUsuario(), request.getContraseña())) {
      if (index != -1) {
        intentosFallidos[index] = 0; // Reinicia el contador de intentos fallidos
      }
      return true;
    }

    // Si la IP ya existe, incrementa el contador de intentos fallidos
    if (index != -1) {
      intentosFallidos[index]++;
    } else {
      // Si la IP no existe, busca el primer espacio vacío en el arreglo
      for (int i = 0; i < ips.length; i++) {
        if (ips[i] == null) {
          index = i;
          ips[i] = ip;
          intentosFallidos[i] = 1; // Inicia el contador de intentos fallidos
          break;
        }
      }
    }

    // Si se supera el número máximo de intentos, bloquea la IP
    if (intentosFallidos[index] >= MAX_INTENTOS) {
      System.out.println("IP bloqueada por demasiados intentos fallidos.");
      return false;
    }

    // Imprime mensaje de fallo en la autenticación
    System.out.println("Fallo en la autenticación.");
    return false;
  }

  // Funcion que valida las credenciales
  private boolean validarCredenciales(String username, String password) {
    try (BufferedReader br = new BufferedReader(new FileReader(USUARIOS_FILE))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] partes = line.split(",");
        if (partes.length == 3) {
          String storedUsername = partes[0];
          String storedPassword = partes[1];
          if (storedUsername.equals(username) && storedPassword.equals(password)) {
            return true;
          }
        }
      }
    } catch (IOException e) { // Captura excepcicon en caso de no poder leer el .txt
      e.printStackTrace();
    }
    return false;
  }

  public boolean isIpBlocked(String ip) {
    // Buscar si la IP está bloqueada
    for (int i = 0; i < ips.length; i++) {
      if (ip.equals(ips[i]) && intentosFallidos[i] >= MAX_INTENTOS) {
        return true;
      }
    }
    return false;
  }
  }

