public class AlgoritmosDeBusqueda {

    // Búsqueda Lineal
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;  // No encontrado
    }

    // Búsqueda Lineal Limitada (limitamos la búsqueda a "limit" elementos)
    public static int linearSearchLimited(int[] array, int target, int limit) {
        for (int i = 0; i < Math.min(array.length, limit); i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;  // No encontrado
    }

    // Búsqueda Binaria (el arreglo debe estar ordenado)
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (array[middle] == target) {
                return middle;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;  // No encontrado
    }

    // Búsqueda por Saltos (Jump Search)
    public static int jumpSearch(int[] array, int target) {
        int n = array.length;
        int step = (int) Math.sqrt(n);  // Tamaño de bloque
        int prev = 0;

        while (array[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) return -1;
        }

        for (int i = prev; i < Math.min(step, n); i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;  // No encontrado
    }

    // Medir el tiempo de ejecución
    public static long measureSearchTime(int[] array, int target, SearchFunction searchFunction) {
        long startTime = System.nanoTime();
        searchFunction.search(array, target);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Interfaz funcional para facilitar la medición del tiempo
    @FunctionalInterface
    public interface SearchFunction {
        int search(int[] array, int target);
    }
}
