package geeksforgeeks.sorting;

public class MergeSort {

    private static int[] array = {20,35,85,7,55,1,-22,-37};

    public static void main(String[] args) {
        mergeSortMethod(array,0,array.length-1);
        for(int k=0;k<array.length;k++){
            System.out.print(array[k]+" ");
        }
    }

    private static void mergeSortMethod(int[] array, int start,int end){
        if(start<end){
            int mid = (start + end)/2;
            mergeSortMethod(array,start,mid);
            mergeSortMethod(array,mid+1,end);
            merge(array,start,mid,end);
        }
    }

    private static void merge(int[] array,int start,int mid,int end){
        int i=start;
        int j=mid+1;
        int[] temp = new int[end-start+1];
        int tempIndex=0;
        for(int k=start;k<=end;k++){
            if(i>mid)
                temp[tempIndex++]=array[j++];
            else if(j>end)
                temp[tempIndex++]=array[i++];
            else if(array[i]>array[j])
                temp[tempIndex++] = array[i++];
            else
                temp[tempIndex++] = array[j++];
        }
        for(int b=0;b<tempIndex;b++){
            array[start++] = temp[b];
        }
    }
}
