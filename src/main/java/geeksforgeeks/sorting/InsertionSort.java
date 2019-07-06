package geeksforgeeks.sorting;

public class InsertionSort {

    private static int[] array = {20,35,85,7,55,1,-22,-37};

    public static void main(String[] args) {
        for(int firstIndexSortedPartition=0;firstIndexSortedPartition<array.length;firstIndexSortedPartition++){
            int newElement = array[firstIndexSortedPartition];
            int j = firstIndexSortedPartition;
            while(j>0 && newElement<array[j-1]){
                array[j] = array[j-1];
                j--;
            }
            array[j] = newElement;
        }
        for(int k=0;k<array.length;k++){
            System.out.print(array[k]+" ");
        }
    }
}
