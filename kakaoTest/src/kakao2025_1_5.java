

public class kakao2025_1_5 {
	public class App{
		int id;
		int x;
		int y;
		int h;
		int w;
		
		public App(int id, int x, int y, int h, int w) {
			super();
			this.id = id;
			this.x = x;
			this.y = y;
			this.h = h;
			this.w = w;
		}
	}
	
	public static int[][] rdlu;
	
	public static void main(String[] args) throws Exception {
		 int[][] arr1 = {
			    {0, 2, 2, 0, 0, 0, 0, 0},
			    {0, 2, 2, 0, 0, 4, 4, 0},
			    {0, 3, 3, 3, 1, 4, 4, 0},
			    {0, 3, 3, 3, 0, 0, 0, 0},
			    {0, 3, 3, 3, 5, 5, 6, 0},
			    {0, 0, 0, 0, 5, 5, 0, 0}
			};
		  int[][] arr2 = {
			    {0, 9, 1, 1, 6, 0, 0, 0},
			    {2, 2, 1, 1, 0, 0, 0, 0},
			    {2, 2, 3, 4, 4, 4, 0, 0},
			    {5, 0, 0, 4, 4, 4, 7, 0},
			    {0, 0, 0, 4, 4, 4, 8, 8},
			    {0, 0, 0, 0, 0, 0, 8, 8}
			};
		  int[][] arr3 = {
			    {1, 1, 0},
			    {1, 1, 0}
			};
		
		  int[][] cmd1 = {
			    {3, 1},
			    {3, 1}
			};
		
		  int[][] cmd2 = {
			    {2, 1},
			    {3, 1},
			    {9, 2},
			    {4, 1}
			};
		int[][] cmd3 = {{1, 4}, {1, 3}, {1, 2}};
		
		int[][] result1 = solution(arr1, cmd1);
		int[][] result2 = solution(arr2, cmd2);
		int[][] result3 = solution(arr3, cmd3);
	}
	
    public static int[][] solution(int[][] board, int[][] commands) {
        int[][] answer = {};
        return answer;
    }
    
    public static int pushApp(App app, int dir, int val) { 
    	app.
    }
    
    
    
	
}
