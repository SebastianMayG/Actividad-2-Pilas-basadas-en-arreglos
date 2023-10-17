import java.util.Arrays;

public class BubbleSort 
{
    public static int[] bubbleSort(int arr[])
    {
        boolean swap = true;
        
        while(swap == true)
        {
            swap = false;

            for(int i = 0; i < arr.length; i++)
            {
                for(int j = 0; j < arr.length-1; j++)
                {
                
                    if(arr[j] > arr[j+1])
                    {
                        int aux = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = aux;

                        System.out.println("-" + Arrays.toString(arr));
                        swap = true;
                    }
                }
            }    
        }
        return arr;
    }    
}
