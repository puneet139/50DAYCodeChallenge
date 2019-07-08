package geeksforgeeks.sorting;

public class QuickSort {

    private static int[] array = {20,35,85,7,55,1,-22,-37};

    public static void main(String[] args) {
        quickSort(array,0,array.length-1);
        for(int k=0;k<array.length;k++){
            System.out.print(array[k]+" ");
        }
    }

    private static void quickSort(int[] array,int start, int end){
        if(start<end){
            int pivot = array[start];
            int pivotIndex = partition(array,pivot,start,end);
            quickSort(array,start,pivotIndex-1);
            quickSort(array,pivotIndex+1,end);
        }
    }

    private static int partition(int[] array,int pivot, int start,int end){
        int i = start+1;
        int j = end;
        while(i<j){
            while(array[j]>=pivot){
                j--;
            }
            while(array[i]<=pivot){
                i++;
            }
            if(i<j){
                int elem = array[i];
                array[i] = array[j];
                array[j]=elem;
            }
        }
        array[start] = array[j];
        array[j]=pivot;
        return j;
    }

}
