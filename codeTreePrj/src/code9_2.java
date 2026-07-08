import java.io.*;
import java.util.*;

public class code9_2 {
	public static final int INT_MIN = -100_000_000; 
	public static int[][] dr = {{1,0},{0,1}};
	public static int N;
	public static int T;
	public static int[][] board;
	public static int[][][] maxLeap;
	
		
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		maxLeap = new int[N][N][T+1];
		
		for(int r=0; r<N; ++r) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; ++c) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r=0; r<N; ++r) {
			for(int c=0; c<N; ++c) {
				Arrays.fill(maxLeap[r][c], Integer.MIN_VALUE);
			}
		}
		
		System.out.println(simulation());
		
	}
	
	public static int simulation() {
		
		int[][][] maxVal = new int[N][N][2]; // r+1, c+1, 시간역행유무
		maxVal[0][0][0] = board[0][0];
		maxVal[0][0][1] = timeLeap(0, 0, T);
		
		for(int r=1; r<N; ++r) {
			maxVal[r][0][0] = maxVal[r-1][0][0] + board[r][0];
			maxVal[r][0][1] = maxVal[r-1][0][1] + board[r][0];
			int leap = timeLeap(r, 0, T);
			if(leap > INT_MIN) { 
				maxVal[r][0][1] = Math.max(maxVal[r][0][1], maxVal[r][0][0] + leap);
			}
		}
		for(int c=1; c<N; ++c) {
			maxVal[0][c][0] = maxVal[0][c-1][0] + board[0][c];
			maxVal[0][c][1] = maxVal[0][c-1][1] + board[0][c];
			int leap = timeLeap(0, c, T);
			if(leap > INT_MIN) { 
				maxVal[0][c][1] = Math.max(maxVal[0][c][1], maxVal[0][c][0] + leap);
			}
		}
		
		
		for(int r=1; r<N; ++r) {
			for(int c=1; c<N; ++c) {
				maxVal[r][c][0] = Math.max(maxVal[r-1][c][0],maxVal[r][c-1][0]) + board[r][c];
				maxVal[r][c][1] = Math.max(maxVal[r-1][c][1],maxVal[r][c-1][1]) + board[r][c];
				int leap = timeLeap(r, c, T);
				if(leap > INT_MIN) { 
					maxVal[r][c][1] = Math.max(maxVal[r][c][1], maxVal[r][c][0] + leap);
				}
				
			}
		}
		
		return Math.max(maxVal[N-1][N-1][0], maxVal[N-1][N-1][1]);
		
		
	}

	
	
	public static int timeLeap(int row, int col, int t) {
		// 현재 위치에서 t만큼 갔을떄 얻을 수 있는 최대 점수
		if(row+col+t>2*N-2) return INT_MIN; // 시간 역행 불가능
		if(row >= N || col >= N) return INT_MIN;
		if(t==0) return board[row][col];

		
		if(maxLeap[row][col][t] > INT_MIN) return maxLeap[row][col][t];
		
		int max = Math.max(timeLeap(row+1, col, t-1), timeLeap(row, col+1, t-1));
		if(max <= INT_MIN) return INT_MIN;
		return maxLeap[row][col][t] = max + board[row][col];
				
	
	}
}
