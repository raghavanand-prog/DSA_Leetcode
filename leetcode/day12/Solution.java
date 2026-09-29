class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Path length is m + n - 1 (excluding start)
        // Valid string must have even length (equal '(' and ')')
        if ((m + n - 1) % 2 == 1)
            return false;

        // Start must be '(' and end must be ')'
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;

        // dp[i][j][bal] = can we reach (i,j) with balance 'bal'
        // balance = count of '(' minus count of ')'
        boolean[][][] dp = new boolean[m][n][m + n];

        dp[0][0][1] = true; // Start with one '('

        // For each position in grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // For each possible balance at this position
                for (int bal = 0; bal < m + n; bal++) {

                    // If we can't reach (i,j) with balance bal, skip
                    if (!dp[i][j][bal])
                        continue;

                    // Try moving down
                    if (i + 1 < m) {
                        int next = bal + (grid[i + 1][j] == '(' ? 1 : -1);

                        // Only proceed if balance remains non-negative
                        if (next >= 0)
                            dp[i + 1][j][next] = true;
                    }

                    // Try moving right
                    if (j + 1 < n) {
                        int next = bal + (grid[i][j + 1] == '(' ? 1 : -1);

                        // Only proceed if balance remains non-negative
                        if (next >= 0)
                            dp[i][j + 1][next] = true;
                    }
                }
            }
        }

        // Answer: can we reach bottom-right with balance 0 (valid parentheses)
        return dp[m - 1][n - 1][0];
    }
}
