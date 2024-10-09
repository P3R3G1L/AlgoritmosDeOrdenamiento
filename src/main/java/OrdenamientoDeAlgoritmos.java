import java.util.Arrays;

public class OrdenamientoDeAlgoritmos {

    //Algoritmo burbuja
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    //Algoritmo QuicSort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    //Algoritmo StoogeSort
    public static void stoogeSort(int[] array, int low, int high) {
        if (low >= high) return;

        if (array[low] > array[high]) {
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }

        if (high - low + 1 > 2) {
            int t = (high - low + 1) / 3;
            stoogeSort(array, low, high - t);
            stoogeSort(array, low + t, high);
            stoogeSort(array, low, high - t);
        }
    }

    //Algoritmo PigeonholeSort
    public static void pigeonhole_sort(int arr[], int n)
    {
        int min = arr[0];
        int max = arr[0];
        int range, i, j, index;

        for(int a=0; a<n; a++)
        {
            if(arr[a] > max)
                max = arr[a];
            if(arr[a] < min)
                min = arr[a];
        }

        range = max - min + 1;
        int[] phole = new int[range];
        Arrays.fill(phole, 0);

        for(i = 0; i<n; i++)
            phole[arr[i] - min]++;


        index = 0;

        for(j = 0; j<range; j++)
            while(phole[j]-->0)
                arr[index++]=j+min;

    }

    //Argoritmo MergeSort
    static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void sortSort(int arr[], int l, int r)
    {
        if (l < r) {

            int m = l + (r - l) / 2;

            sortSort(arr, l, m);
            sortSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    //BitonicSort
    static void compAndSwap(int a[], int i, int j, int dir)
    {
        if ( (a[i] > a[j] && dir == 1) ||
                (a[i] < a[j] && dir == 0))
        {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    static void bitonicMerge(int a[], int low, int cnt, int dir)
    {
        if (cnt>1)
        {
            int k = cnt/2;
            for (int i=low; i<low+k; i++)
                compAndSwap(a,i, i+k, dir);
            bitonicMerge(a,low, k, dir);
            bitonicMerge(a,low+k, k, dir);
        }
    }

    static void bitonicSort(int a[], int low, int cnt, int dir)
    {
        if (cnt>1)
        {
            int k = cnt/2;

            bitonicSort(a, low, k, 1);

            bitonicSort(a,low+k, k, 0);

            bitonicMerge(a, low, cnt, dir);
        }
    }

    static void sort(int a[], int N, int up)
    {
        bitonicSort(a, 0, N, up);
    }



    // Medir el tiempo de ejecución
    public static long measureSortTime(int[] array, Runnable sortAlgorithm) {
        long tiempoInicio = System.nanoTime();
        sortAlgorithm.run();
        long tiempoFin = System.nanoTime();
        return tiempoFin - tiempoInicio;
    }
}

