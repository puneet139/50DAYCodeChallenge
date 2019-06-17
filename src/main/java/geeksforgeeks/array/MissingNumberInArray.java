package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MissingNumberInArray {

    private static int[] array;
    private static List<Integer> result = new ArrayList();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numTestCases = Integer.parseInt(br.readLine());
        while(numTestCases-- > 0){
            int arraySize = Integer.parseInt(br.readLine());
            array = new int[arraySize-1];
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            for(int j=0;j<arraySize-1;j++){
                array[j] = Integer.parseInt(strs[j]);
            }
            result.add(calculateMissingNumber(array,arraySize));
        }
        result.forEach(element->System.out.println(element));
    }

    private static int calculateMissingNumber(int[] array,int arraySize){
        int correctSum = (arraySize * (arraySize+1))/2;
        List<Integer> arrayAsList = Arrays.stream(array).boxed().collect(Collectors.toList());
        int sum = arrayAsList.stream().reduce(0,Integer::sum);
        return correctSum - sum;
    }
}
