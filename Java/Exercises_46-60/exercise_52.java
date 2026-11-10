class Solution {
    public int totalNQueens(int n) {
        int mask = (1 << n) - 1;

        return backtrack(0, 0, 0, 0, mask, n);
    }

    private int backtrack(
        int row,
        int columns,
        int diagLeft,
        int diagRight,
        int mask,
        int n
    ) {
        if (row == n) {
            return 1;
        }

        int count = 0;

        int available = mask & ~(columns | diagLeft | diagRight);

        while (available != 0) {
            int bit = available & -available;
            available ^= bit;

            count += backtrack(
                row + 1,
                columns | bit,
                ((diagLeft | bit) << 1) & mask,
                (diagRight | bit) >>> 1,
                mask,
                n
            );
        }

        return count;
    }
}


public class exercise_52 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(4));
        System.out.println(solution.totalNQueens(1));
    }
}