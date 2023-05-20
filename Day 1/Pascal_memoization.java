import java.io.*;
import java.util.*;

class Pascal_memoization {
  private static Map<String, Integer> memo = new HashMap<>();
    
	public static void main (String[] args) {
		int rows = 5;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(calculatePascalValue(i, j) + " ");
            }
            System.out.println();
        }
	}
	
	private static int calculatePascalValue(int row, int col) {
        String key = row + "-" + col;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        if (col == 0 || col == row) {
            memo.put(key, 1);
            return 1;
        }
        
        int value = calculatePascalValue(row - 1, col - 1) + calculatePascalValue(row - 1, col);
        memo.put(key, value);
        return value;
    }
}