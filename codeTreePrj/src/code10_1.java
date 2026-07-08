import java.util.*;
import java.io.*;

public class code10_1 {
	public static int N;
	public static int K;
	public static int[] positions;
	public static final int MAX_PATCH = 1_000_000_000;
	
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());

        positions = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i) {
            positions[i] = Integer.parseInt(st.nextToken());
        }
        // Please write your code here.
        System.out.println(lower());
        
    }
    
    public static int lower() {
    	int left = 1;
    	int right = MAX_PATCH;

    	while(left<right) {
        	int mid = (left+right)/2;
        	
        	if(canCover(mid))
        		right = mid;
        	else
        		left = mid+1;
    	}
    	
    	return left;
    }
    
    public static boolean canCover(int patch) {
    	int p = 0;
    	int now = 0;
    	int len = positions.length;
    	int cnt = 0;
    	while(p < len) {
    		now = positions[p] + patch-1;
    		cnt++;
    		if(cnt>K) 
    			return false;
    		while(++p < len) {
    			if(positions[p] > now) break;
    		}
    	}
    	if(cnt>K) return false;
    	return true;
    }
}
