public class BusquedaBinaria 
{
    public static int[] quickSort(int arr[]) 
    {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static int[] quickSort(int arr[], int primero, int ultimo) 
    {
        int i, j, central;
        double pivote;

        central = (primero + ultimo) / 2;
        pivote = arr[central];

        i = primero;
        j = ultimo;

        do {
            while (arr[i] < pivote)
                i++;
            while (arr[j] > pivote)
                j--;

            if (i <= j) {
                int aux = arr[i];
                arr[i] = arr[j];
                arr[j] = aux;

                i++;
                j--;
            }

        } while (i <= j);
        {
            if (primero < j)
                quickSort(arr, primero, j);

            if (i < ultimo)
                quickSort(arr, i, ultimo);
            return arr;
        }

    }

    public static int busquedaBinaria(int arr[], int n) 
    {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int centro = ((inicio + fin) / 2) + 1;

            if (arr[centro] == n) {
                return centro;
            } else if (arr[centro] < n) {
                inicio = centro + 1;

            } else {

                fin = centro - 1;
            }

        }
        return -1;
    }
}