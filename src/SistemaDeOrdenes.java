public class SistemaDeOrdenes extends AbstractHandler {

    @Override
    public boolean handle(SolicitudLogin request) {
        System.out.println("Ha ingresado existosamente al sistema de ordenes");
        request.setValidacion(true);
        return true;
    }
}
