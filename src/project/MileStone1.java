package project;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MileStone1 
{  
    static int partition(int[] arr,int lower,int higher)
    {
        int pivot = arr[higher];
        int i = (lower-1);
        for(int j=lower;j<higher;j++)
        {
            if(arr[j]<=pivot)
            {
                i++;
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[higher];
        arr[higher]=temp;
        return(i+1);
    }
    
    public static void insertionSort(int[] arr , int low , int high) 
    {  
        for(int i=low+1;i<=high;i++){
            for(int j=i-1;j>=low;j--){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
                else
                    break;
            }
        }
    }
    
    public static void HybirdSort(int arr[],int lower,int higher)
    {
        while(lower<higher)
        {
            if(higher-lower<10)
            {
                insertionSort(arr,lower,higher);
                break;
            }
            else //This is Quick-Sort
            {
                int pivot = partition(arr,lower,higher);
                
                if(pivot-lower<pivot-higher)
                {
                    HybirdSort(arr,lower,pivot-1);
                    lower=pivot+1;
                }
                else
                {
                    HybirdSort(arr,pivot+1,higher);
                    higher=pivot-1;
                }
            }
        }
    }
    
    static void quickSort(int array[],int low,int high)
    {
        if(low<high)
        {
            int pi=partition(array,low,high);
            quickSort(array,low,pi-1);
            quickSort(array,pi+1,high);
        }
    }
    
    static void printArray(int arr[])
    {
        for(int i = 0 ; i < arr.length ; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int size;
        System.out.println("Welcome to our program.");
        System.out.print("Please choose the array size: ");
        size=input.nextInt();
        int[] array=new int[size];
        for(int i=0 ; i < array.length ; i++)
        {
            array[i] = (int)(Math.random()*100);
        }
        int[] array2=new int[array.length];
        for (int i = 0; i < array.length; i++) 
        {
            array2[i] = array[i];
        }
        int[] array3=new int[array.length];
        for (int i = 0; i < array.length; i++) 
        {
            array3[i] = array[i];
        }
        int[] array4=new int[array.length];
        for (int i = 0; i < array.length; i++) 
        {
            array4[i] = array[i];
        }
        //int[] array={2,4,6};
        //I WILL BRING MY OWN ARRAY
        
        for(int i=0 ; i < array.length ; i++)
        {
            array[i] = (int)(Math.random()*100);
        }
        boolean bool = false;
        do
        {
            System.out.println("Choose what sorting algorithm you want to use:");
            System.out.println("1- Insertion-Sort.");
            System.out.println("2- Quick-Sort.");
            System.out.println("3- Hybrid-Sort.");
            int choice = 0;
            while(choice != -1)
            {   
                try
                {
                    System.out.println("Enter 1,2,3 to choose. Enter -1 to exit.");
                    System.out.println();
                    choice = input.nextInt();
                    switch(choice)
                    {
                        case 1:
                            System.out.println("Unsorted array:   ");
                            // print the unsorted array
                            printArray(array);
                            long startTime = System.nanoTime();
                            insertionSort(array2,0,array2.length-1);
                            long stopTime = System.nanoTime()-startTime;
                            stopTime/=1000;
                            System.out.println("\nExecution time in nano seconds: " + stopTime + " ns");
                            System.out.println("\nSorted array using Insertion-Sort:");
                            // print the sorted array
                            printArray(array2);
                            System.out.println();
                            break;
                        case 2:
                            System.out.println("Unsorted array:   ");
                            // print the unsorted array
                            printArray(array);
                            startTime = System.nanoTime();
                            quickSort(array3, 0, array3.length-1);
                            stopTime = System.nanoTime()-startTime;
                            stopTime/=1000;
                            System.out.println("\nExecution time in nano seconds: " + stopTime + " ns");
                            System.out.println("\nSorting using Quick-Sort:");
                            // print the sorted array
                            printArray(array3);
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("Unsorted array:   ");
                            //print the unsorted array
                            printArray(array);
                            startTime = System.nanoTime();
                            HybirdSort(array4, 0, array4.length-1);

                            stopTime = System.nanoTime()-startTime;
                            stopTime/=1000;
                            System.out.println("\nExecution time in nano seconds: " + stopTime + " ns");
                            System.out.println("\nSorting using Hybrid-Sort:");;
                            // print the sorted array
                            printArray(array4);
                            System.out.println();
                            break;
                        case -1:
                            bool = true;
                            break;
                        default:
                            System.out.println("Wrong input. Please try again.");
                            break;
                    }
                } catch(InputMismatchException e)
                {
                    System.out.println("Wrong input. Please enter a number.");
                }
            }
        }while(bool == false);
        System.out.println();
    }

}

