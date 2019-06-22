package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArrayLeader {

    private static int[] input;
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numTestCases = Integer.parseInt(br.readLine());
        while(numTestCases-- > 0){
            int arraySize = Integer.parseInt(br.readLine());
            input = new int[arraySize];
            String line = br.readLine();
            String[] str = line.split("\\s+");
            for(int i=0;i<str.length;i++){
                input[i]=Integer.parseInt(str[i]);
            }
            result = getLeaderInArray(input,arraySize);
            for(int r:result)
                System.out.print(r+" ");
            System.out.println();
        }
    }

    private static List<Integer> getLeaderInArray(int[] input,int arraySize){
        List<Integer> res = new ArrayList<>();
        boolean[] isNotLeader = new boolean[arraySize];
        for(int j=0;j<arraySize-1;j++){
            for(int k=arraySize-1;k>j;k--) {
                if (!(input[j] >= input[k])) {
                    isNotLeader[j]=true;
                    break;
                }
            }
            if(!isNotLeader[j]){
                res.add(input[j]);
            }
        }
        res.add(input[arraySize-1]);
        return res;
    }
}
