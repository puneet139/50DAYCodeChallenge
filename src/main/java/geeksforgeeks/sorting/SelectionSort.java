package geeksforgeeks.sorting;

public class SelectionSort {

    private static int[] array = {20,35,-15,7,55,1,-22,37};

    public static void main(String[] args) {
        for(int i=0;i<array.length-1;i++){
            int minElementIndex = i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[minElementIndex]){
                    minElementIndex = j;
                }
            }
            int element = array[i];
            array[i] = array[minElementIndex];
            array[minElementIndex] = element;
        }
        for(int k=0;k<array.length;k++){
            System.out.print(array[k]+" ");
        }
    }
}
