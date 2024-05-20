import java.util.Objects;
import java.util.Scanner;

public class SistemaDeOrdenes extends AbstractHandler {

    @Override
    public boolean handle(SolicitudLogin request) {
        System.out.println(String.format("Ha ingresado existosamente al sistema de ordenes como %s", request.getTipo()));
        SistemaOrdenes(request);
        request.setValidacion(true); // Para cerrar el bucle en la clase Cliente
        return true;
    }

    public void SistemaOrdenes(SolicitudLogin request) {

        boolean stop = false;
        while (!stop) {
            System.out.println("Seleccione la accion que desea realizar: ");
            System.out.println("1. Crear pedido\n2. Editar Pedido\n3. Consultar Pedido\n4. Eliminar Pedido\n5. Salir");
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("**Pedido creado con exito**");
                    break;
                case 2:
                    System.out.println("**Pedido editado**");
                    break;
                case 3:
                    System.out.println("**Consultando pedido...**");
                    break;
                case 4:
                    if (Objects.equals(request.getTipo(), "usuario")) {
                        System.out.println("ESTA ÓPCION SOLO ESTA DISPONIBLE PARA EL ADMINISTRADOR");
                    } else if (Objects.equals(request.getTipo(), "admin")) {
                        System.out.println("**Pedido Eliminado**");
                    }
                    break;
                case 5:
                    System.out.println("Ha salido del sistema");
                    stop = true;
                    break;
                default:
                    System.out.println("Digite una opcion valida");
                    break;
            }
        }
    }
}
