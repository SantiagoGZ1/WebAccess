import java.util.Random;

public class GeneradorIp {

    public int random() {
        Random random = new Random();
        int ipRandom = (int)(Math.random() * 900_000_000) + 100_000_000;
        return ipRandom;
    }

    public void guardarIp() {
        int numeroGuardado = random();
        System.out.println(numeroGuardado);
    }
}
