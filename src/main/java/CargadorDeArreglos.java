import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CargadorDeArreglos {

    public static int[] cargarArregloDeArchivo(String nombreArchivo) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
        String line;
        while ((line = reader.readLine()) != null) {
            list.add(Integer.parseInt(line));
        }
        reader.close();

        // Convertir la lista a un arreglo
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
