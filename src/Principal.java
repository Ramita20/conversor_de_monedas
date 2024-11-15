import com.challengealura.modelos.ConversorDeMoneda;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConversorDeMoneda conversor = new ConversorDeMoneda();
        conversor.ejecutar();
    }
}
