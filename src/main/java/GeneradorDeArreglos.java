import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeneradorDeArreglos {

    public static void generarArreglo(int tamanio, String nombreArchivo) throws IOException {
        Random random = new Random();
        FileWriter writer = new FileWriter(nombreArchivo);

        for (int i = 0; i < tamanio; i++) {
            int number = 10000000 + random.nextInt(90000000); // Números de 8 dígitos
            writer.write(number + "\n");
        }
        writer.close();
    }
}
