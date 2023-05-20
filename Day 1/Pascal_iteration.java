import java.io.*;
import java.util.*;

class Pascal_iteration {
  private static Map<String, Integer> memo = new HashMap<>();
    
	public static void main (String[] args) {
		int rows = 5; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(calc(i, j) + " ");
            }
            System.out.println();
        }
	}
	
	private static int calc(int row, int col) {
        String key = row + "-" + col;
        if (col == 0 || col == row) {
            memo.put(key, 1);
            return 1;
        }
        
        int val;
        if(memo.containsKey(key)){
            val = memo.get(key);
        }
        else{
            val = memo.get((row - 1) + "-" + (col - 1)) + memo.get((row - 1) + "-" + col);
            memo.put(key, val);
        }
        return val;
    }
}