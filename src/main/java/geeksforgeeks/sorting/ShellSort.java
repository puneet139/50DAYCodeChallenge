package geeksforgeeks.sorting;

public class ShellSort {

    private static int[] array = {20,35,85,7,50,1,-22,-37};

    public static void main(String[] args) {
        for(int gap=array.length/2;gap>0;gap=gap/2){

            for(int j=gap;j<array.length;j++){
                int temp = array[j];
                int k=j;
                for(k=j;k>=gap && temp<array[k-gap];k=k-gap){
                    array[k] = array[k-gap];
                }
                array[k] = temp;
            }
        }
        for(int k=0;k<array.length;k++){
            System.out.print(array[k]+" ");
        }
    }
}
