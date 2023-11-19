import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        int[] arr = new int[1000];
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 1000; i++)
        {
            arr[i] = (int)(Math.random()*100000);
        }

        BusquedaBinaria.quickSort(arr);
        
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + ", ");
        }

        System.out.print("\n¿Qué número desea buscar en el arreglo? ");

        int x = input.nextInt();
        System.out.println("Se encuentra en la posicion: " + BusquedaBinaria.busquedaBinaria (arr,x));

    }
}
