import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {

//    private static Scanner scanner = new Scanner(System.in);

    public static int[] getIntegers(int sizeOfArray)
    {
        Scanner scanner = new Scanner(System.in);
        int [] array = new int[sizeOfArray];
        System.out.println("Enter " + sizeOfArray + " integer values:\r");
        for(int i=0; i<array.length; i++)
        {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        return array;
    }

    public static void printArray(int[] array)
    {
        for(int i=0; i<array.length; i++)
        {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array)
    {
//        int[] sortedArray = new int[array.length];
//        for(int i=0; i<array.length; i++)
//        {
//            sortedArray[i] = array[i];
//        }
        int[] sortedArray = Arrays.copyOf(array, array.length);

        boolean flag = true;
        int temp;

        while (flag)
        {
            flag = false;
            for(int i=0; i<sortedArray.length-1; i++)
            {
                if(sortedArray[i] < sortedArray[i+1])
                {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
}
