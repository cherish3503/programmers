import java.util.*;
import java.io.*;
public class code9_1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		String inp = br.readLine();
		
		if(security(inp)) System.out.println("Yes");
		else System.out.println("No");
	}
	
	public static boolean security(String inp) {
		int cntUp = 0;
		int cntQ = 0;
		for(int i=0; i<inp.length(); ++i) {
			if(inp.charAt(i) == '(') {
				cntUp++;
			}
			else if(inp.charAt(i) == ')') {
				if(cntUp + cntQ <= 0) return false;
				cntUp--;
			}
			else if(inp.charAt(i) == '?') {
				cntQ++;
			}
		}
		
		if(Math.abs(cntUp) > cntQ) return false;
		return simulation(inp, (cntQ-cntUp)/2);
		
	}
	
	public static boolean simulation(String inp, int qToUp){
		int cntUp = 0;

		for(int i=0; i<inp.length(); ++i) {
			if(inp.charAt(i) == '(') {
				cntUp++;
			}
			else if(inp.charAt(i) == ')') {
				if(--cntUp < 0) return false;
				
			}
			else if(inp.charAt(i) == '?') {
				if(qToUp-- > 0) cntUp++;
				else if(--cntUp < 0) return false;
			}
		}
		
		if(cntUp != 0) return false;
		return true;
	}
}
