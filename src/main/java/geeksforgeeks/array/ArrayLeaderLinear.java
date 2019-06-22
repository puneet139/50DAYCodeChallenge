package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayLeaderLinear {

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
            result.add(Integer.parseInt(str[str.length - 1]));
            int max = Integer.parseInt(str[str.length - 1]);
            for(int i=str.length-2;i>=0;i--){
                input[i]=Integer.parseInt(str[i]);
                if ((input[i] >= max)) {
                    max = input[i];
                    result.add(input[i]);
                }
            }
            //result = getLeaderInArray(input,arraySize);
            Collections.reverse(result);
            StringBuffer sb = new StringBuffer();
            for(int r:result)
                sb.append(r+" ");
            System.out.println(sb);
            result.clear();
        }
    }
}

