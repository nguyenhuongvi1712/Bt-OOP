package Lab02;
import java.util.Random;
import java.util.Scanner;

public class LArray {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int size;
        int [] RdArray = CreateRandomArray(1000,100);
        do{
            System.out.print("Enter size of array (<=1000): ");
            size = Integer.parseInt(sc.nextLine());
            if (size >1000)
                System.out.println("Size of array must >1000 . Please enter again: ");
        }while (size >1000);
        int [] LArray = CreateArray(size,sc,RdArray);
        SortArray(LArray);
        toString(LArray);
    }
    static int[] CreateRandomArray(int size,int limit){
        int[] array = new int[size];
        Random rd = new Random();
        for (int i=0;i<size;i++){
            array[i] = rd.nextInt(limit);
        }
        return array;
    }
    static int[] CreateArray(int size,Scanner sc,int[] RdArray){
        int[] array = new int[size];
        String c;
        for (int i=0;i<size;i++){
            System.out.print("Enter array["+i+"] : ");
            c = sc.nextLine();
            if(!c.equals("$"))
                array[i] = Integer.parseInt(c);
            else
                array[i] = RdArray[i];
        }
        return array;
    }
    static void toString(int[] array){
        int sum=0;
        System.out.println("All the values from the array : ");
        for (int i = 0 ; i<array.length;i++){
            sum += array[i];
            System.out.print(array[i]+" ");
        }
        System.out.println("\nSum of array : "+sum);
        System.out.println("Average of array : "+(float)sum/array.length);
    }
    static void SortArray(int[] array){
        int a;
        for (int i = 0 ; i < array.length;i++){
            for (int j=i+1; j < array.length ; j++){
                if(array[i] > array[j]){
                    a = array[i];
                    array[i] = array[j];
                    array[j] = a;
                }
            }
        }
    }
}
