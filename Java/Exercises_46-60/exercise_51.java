import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();

        int[] queenColumns = new int[n];
        int mask = (1 << n) - 1;

        backtrack(0, 0, 0, 0, mask, queenColumns, solutions);

        return solutions;
    }

    private void backtrack(
        int row,
        int columns,
        int diagLeft,
        int diagRight,
        int mask,
        int[] queenColumns,
        List<List<String>> solutions
    ) {
        int n = queenColumns.length;

        if (row == n) {
            List<String> board = new ArrayList<>(n);

            for (int r = 0; r < n; r++) {
                char[] line = new char[n];
                Arrays.fill(line, '.');

                line[queenColumns[r]] = 'Q';
                board.add(new String(line));
            }

            solutions.add(board);
            return;
        }

        int available = mask & ~(columns | diagLeft | diagRight);

        while (available != 0) {
            int bit = available & -available;
            available ^= bit;

            queenColumns[row] = Integer.numberOfTrailingZeros(bit);

            backtrack(
                row + 1,
                columns | bit,
                ((diagLeft | bit) << 1) & mask,
                (diagRight | bit) >>> 1,
                mask,
                queenColumns,
                solutions
            );
        }
    }
}


public class exercise_51 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Solution solution = new Solution();

        List<List<String>> result = solution.solveNQueens(n);

        System.out.println("Number of solutions: " + result.size());

        for (List<String> board : result) {
            for (String row : board) {
                System.out.println(row);
            }

            System.out.println();
        }

        scanner.close();
    }
}
