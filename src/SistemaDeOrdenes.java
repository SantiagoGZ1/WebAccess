public class SistemaDeOrdenes extends AbstractHandler {

    @Override
    public boolean handle(SolicitudLogin request) {
        System.out.println(STR."Ha ingresado existosamente al sistema de ordenes como \{request.getTipo()}");
        request.setValidacion(true); // Para cerrar el bucle en la clase Cliente
        return true;
    }
}
