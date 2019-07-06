package geeksforgeeks.sorting;

public class BubbleSort {

    private static int[] array = {20,35,-15,7,55,1,-22,37};

    public static void main(String[] args) {

        for(int i=0;i<array.length-1;i++){
            for(int j=1;j<array.length;j++){
                if(array[j]<array[j-1]){
                    int numElement = array[j-1];
                    array[j-1] = array[j];
                    array[j] = numElement;
                }
            }
        }

        for(int k=0;k<array.length;k++){
            System.out.print(array[k]+" ");
        }

    }
}
