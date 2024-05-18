public class ConcreteHandlerInvalid extends AbstractHandler{
  private String[] ips;
  private int[] intentosFallidos;
  private static final int MAX_INTENTOS = 4;

  public ConcreteHandlerInvalid() {
    ips = new String[MAX_INTENTOS];
    intentosFallidos = new int[MAX_INTENTOS];
  }

  @Override
  public boolean handle(SolicitudLogin request) {
    String ip = request.getIpRequest();

    // Buscar si la IP ya existe en el arreglo
    int index = -1;
    for (int i = 0; i < ips.length; i++) {
      if (ip.equals(ips[i])) {
        index = i;
        break;
      }
    }

    // Si el usuario proporciona credenciales válidas, reiniciar el contador de intentos
    if (index != -1 && "admin1".equals(request.getUsuario()) && "adminpass".equals(request.getContraseña())) {
      intentosFallidos[index] = 0;
      return true; // Permitir que el siguiente manejador procese la solicitud
    }

    // Si la IP ya existe, incrementar el contador de intentos fallidos
    if (index != -1) {
      intentosFallidos[index]++;
    } else {
      // Si la IP no existe, buscar el primer espacio vacío en el arreglo
      for (int i = 0; i < ips.length; i++) {
        if (ips[i] == null) {
          index = i;
          ips[i] = ip;
          break;
        }
      }
    }

    // Si se supera el número máximo de intentos, bloquear la IP
    if (intentosFallidos[index] >= MAX_INTENTOS) {
      System.out.println("IP bloqueada por demasiados intentos fallidos.");
      return false;
    }

    // Imprimir mensaje de fallo en la autenticación
    System.out.println("PROBANDO COSITAS");
    System.out.println(request.getIpRequest());
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
