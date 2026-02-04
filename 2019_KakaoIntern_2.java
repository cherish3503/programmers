import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        s = s.replace("{", "");
        s = s.replace("}}", "");
        
        // StringBuilder sb;
        String[] arrStr = s.split("},");
        // int n = s.size();
        // System.out.println(Arrays.toString(arrStr));
        
        List<Integer> result = new ArrayList<>();
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a.length - b.length);
        List<int[]> ls = new ArrayList<>();
        Map<Integer, Integer> cntMap = new HashMap<>();
        int size = arrStr.length;
        int[][] arr = new int[size][];
        for(int i=0; i<size; ++i){
            String str = arrStr[i];

                // StringBuilder sb = new StringBuilder();
                // for()
            // Sring[] eStr = str.split(",");
            // for(String e : eStr){
            //     pq.add()
            // }
            int[] eStr = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
            // pq.add(eStr);
            ls.add(eStr);
            // System.out.println(Arrays.toString(eStr));
            

        }
        // System.out.println(ls.stream().map(Arrays::toString));
        ls.sort((a,b)->a.length-b.length);
        
        for(int i=0; i<size; ++i){
            for(int j=0; j<(i+1); ++j){
                int e = ls.get(i)[j];
                int cnt = cntMap.getOrDefault(e, 0);
                if(cnt <= 0){
                    result.add(e);
                    
                }
                else{
                    cntMap.put(e, cnt-1);
                }
            }
            
            for(int j=0; j<(i+1); ++j){
                int e = ls.get(i)[j];
                cntMap.put(e, cntMap.getOrDefault(e, 0)+1);
                
                // if(cntMap.get(e) <= 0){
                //     result.offer(e);
                // }
            }
            
            // System.out.println(cntMap);
            
        }
        
        // ls.stream().map(Arrays::toString).forEach(System.out::println);
        // System.out.println();
        
        // while(!pq.isEmpty()){
        //     System.out.println(Arrays.toString(pq.poll()));
        // }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    
    
    //중복 원소
    
    
    
    
}
