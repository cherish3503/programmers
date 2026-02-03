import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int height = board.length;
        int width = board[0].length;
        int[] nowRow = new int[width];
        
        Deque <Integer> dq = new ArrayDeque<>();
        
        for(int c=0; c<width; ++c){
            for(int r=0; r<height; ++r){
                if(board[r][c] != 0){
                    nowRow[c] = r;
                    break;
                }
                
            }
        }
        
        // Arrays.stream(board).map(Arrays::toString).forEach(System.out::println);
        // System.out.println(Arrays.toString(nowRow));
        
        for(int c :moves){
            c = c-1;
            if(nowRow[c]>=height){
                continue;
            }
            // System.out.println(stack.peek());
            
            int board_doll = board[nowRow[c]][c];
            // System.out.println(board_doll);
            nowRow[c]++;
            if(dq.peekLast() != null && dq.peekLast() == board_doll){
                answer+=2;
                dq.pollLast();
                continue;
            }
            
            dq.add(board_doll);
            
            // System.out.println(dq);
        }
        
        
        
        
        return answer;
    }
}
