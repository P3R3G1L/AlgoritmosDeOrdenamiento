import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        // Generar un archivo con 10.000 números
        String filename = "array.txt";
        GeneradorDeArreglos.generarArreglo(10000, filename);

        // Cargar el archivo en un arreglo
        int[] array = CargadorDeArreglos.cargarArregloDeArchivo(filename);

        // Copias del arreglo para cada algoritmo
        int[] bubbleArray = Arrays.copyOf(array, array.length);
        int[] quickArray = Arrays.copyOf(array, array.length);
        int[] stoogeArray = Arrays.copyOf(array, array.length);
        int[] pigeonArray = Arrays.copyOf(array, array.length);
        int[] mergeArray = Arrays.copyOf(array, array.length);
        int[] bitonicArray = Arrays.copyOf(array, array.length);
        // Copia para algoritmos de búsqueda
        int[] arrayBusqueda = Arrays.copyOf(array, array.length);
        Arrays.sort(arrayBusqueda);

        Random rand = new Random();
        int target = array[rand.nextInt(array.length)];

        long linearTime = AlgoritmosDeBusqueda.measureSearchTime(array, target, AlgoritmosDeBusqueda::linearSearch);
        long limitedLinearTime = AlgoritmosDeBusqueda.measureSearchTime(array, target, (arr, t) -> AlgoritmosDeBusqueda.linearSearchLimited(arr, t, 5000));
        long binaryTime = AlgoritmosDeBusqueda.measureSearchTime(array, target, AlgoritmosDeBusqueda::binarySearch);
        long jumpTime = AlgoritmosDeBusqueda.measureSearchTime(array, target, AlgoritmosDeBusqueda::jumpSearch);

        System.out.println("Búsqueda Lineal: " + linearTime + " ns");
        System.out.println("Búsqueda Lineal Limitada: " + limitedLinearTime + " ns");
        System.out.println("Búsqueda Binaria: " + binaryTime + " ns");
        System.out.println("Búsqueda por Saltos: " + jumpTime + " ns");

        System.out.println("____________________________________________________________________________________");
        System.out.println("PUNTO 1");
        System.out.println("____________________________________________________________________________________");

        // Medir el tiempo de Bitonic Sort
        long bitonicTime = OrdenamientoDeAlgoritmos.measureSortTime(bitonicArray,() -> OrdenamientoDeAlgoritmos.sort(bitonicArray, 0, bitonicArray.length - 1));
        System.out.println("Bitonic Sort: " + bitonicTime + " ns");

        // Medir el tiempo de Quick Sort
        long quickTime = OrdenamientoDeAlgoritmos.measureSortTime(quickArray, () -> OrdenamientoDeAlgoritmos.quickSort(quickArray, 0, quickArray.length - 1));
        System.out.println("Quick Sort: " + quickTime + " ns");

        // Medir el tiempo de Merge Sort
        long mergeTime = OrdenamientoDeAlgoritmos.measureSortTime(mergeArray,() -> OrdenamientoDeAlgoritmos.sortSort(mergeArray, 0, mergeArray.length - 1));
        System.out.println("Merge Sort: " + mergeTime + " ns");

        // Medir el tiempo de Pigeonhole Sort
        long pigeonTime = OrdenamientoDeAlgoritmos.measureSortTime(pigeonArray,() -> OrdenamientoDeAlgoritmos.pigeonhole_sort(pigeonArray, pigeonArray.length));
        System.out.println("Pigeon Sort: " + pigeonTime + " ns");

        // Medir el tiempo de Bubble Sort
        long bubbleTime = OrdenamientoDeAlgoritmos.measureSortTime(bubbleArray, () -> OrdenamientoDeAlgoritmos.bubbleSort(bubbleArray));
        System.out.println("Bubble Sort: " + bubbleTime + " ns");

        // Medir el tiempo de Stooge Sort
        long stoogeTime = OrdenamientoDeAlgoritmos.measureSortTime(stoogeArray, () -> {OrdenamientoDeAlgoritmos.stoogeSort(stoogeArray, 0, stoogeArray.length - 1);});
        System.out.println("Stooge Sort: " + stoogeTime + " ns");

        // Crear gráfico de barras con los tiempos obtenidos

        long[] times = {bitonicTime, quickTime, mergeTime, pigeonTime, bubbleTime, stoogeTime};
        String[] algorithms = {"Bitonic Sort","Quick Sort", "Merge Sort", "Pigeon Sort", "Bubble Sort", "Stooge Sort"};

        GraficadorDeTiempo chart = new GraficadorDeTiempo("Algoritmos de Ordenamiento", "Algoritmos", "Tiempo de ejecución (ns)", times, algorithms);
        chart.setSize(800, 400);
        chart.setVisible(true);


    }
}
