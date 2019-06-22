package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
    private static int[] array ;
    private static List<Integer> result = new ArrayList();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numTestCases = Integer.parseInt(br.readLine());
        while(numTestCases-- > 0){
            int arraySize = Integer.parseInt(br.readLine());
            array =  new int[arraySize];
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            for(int j=0;j<arraySize;j++){
                array[j] = Integer.parseInt(strs[j]);
            }
            result.add(getMajorityElement(array,arraySize));
        }
        result.forEach(element->System.out.println(element));
    }

    private static int getMajorityElement(int[] array,int arraysize){
        Map<Integer,Integer> countMap = new LinkedHashMap<>();
        for(int elem:array){
            if(countMap.get(elem)!=null){
                if(countMap.get(elem)> arraysize/2)
                    return elem;
                countMap.put(elem,countMap.get(elem)+1);
            }else{
                countMap.put(elem,1);
            }
        }
        return -1;
    }
}
