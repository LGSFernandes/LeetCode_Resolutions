class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 &&
                    (rowCount[i] > 1 || colCount[j] > 1)) {
                    answer++;
                }
            }
        }

        return answer;
    }
}


public class exercise_1267 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1, 0}, {0, 1}};
        int[][] grid2 = {{1, 0}, {1, 1}};
        int[][] grid3 = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        System.out.println(solution.countServers(grid));
        System.out.println(solution.countServers(grid2));
        System.out.println(solution.countServers(grid3));
    }
}