public class Test {
    static Solution sol = new Solution();

    public static void main(String[] args) {
        int testsPassed = 0;
        int totalTests = 12;

        // Test 1: Basic valid path
        char[][] grid1 = {{'(', ')'}, {'(', ')'}};
        if (sol.hasValidPath(grid1) == false) testsPassed++;
        else System.out.println("Test 1 FAILED: Expected false for [[\"(\",\")\"],[\"(\",\")\"]");

        // Test 2: Single row valid
        char[][] grid2 = {{'(', ')'}};
        if (sol.hasValidPath(grid2) == true) testsPassed++;
        else System.out.println("Test 2 FAILED: Expected true for [\"(\",\")\"]");

        // Test 3: Single cell - impossible (no valid path)
        char[][] grid3 = {{'('}};
        if (sol.hasValidPath(grid3) == false) testsPassed++;
        else System.out.println("Test 3 FAILED: Expected false for single cell");

        // Test 4: Starts with ')' - impossible
        char[][] grid4 = {{')', '('}, {'(', ')'}};
        if (sol.hasValidPath(grid4) == false) testsPassed++;
        else System.out.println("Test 4 FAILED: Expected false when starts with ')'");

        // Test 5: Ends with '(' - impossible
        char[][] grid5 = {{'(', '('}, {'(', '('}};
        if (sol.hasValidPath(grid5) == false) testsPassed++;
        else System.out.println("Test 5 FAILED: Expected false when ends with '('");

        // Test 6: Odd length path - impossible
        char[][] grid6 = {{'(', ')'}, {'(', ')', '('}}; // 1+2-1 = 2 cells, length 2 (even) - actually 5 cells
        // Actually odd dimension: 2 rows x 3 cols = path length 2+3-1=4 (even)
        char[][] grid6b = {{'(', ')', '('}}; // 1x3: path length = 1+3-1=3 (odd)
        if (sol.hasValidPath(grid6b) == false) testsPassed++;
        else System.out.println("Test 6 FAILED: Expected false for odd path length");

        // Test 7: Simple 2x2 with valid path
        char[][] grid7 = {{'(', ')'}, {')', '('}};
        if (sol.hasValidPath(grid7) == false) testsPassed++;
        else System.out.println("Test 7 FAILED: Expected false for [[\"(\",\")\"],[\")\",\"(\"]");

        // Test 8: Must go through cells - cannot skip
        char[][] grid8 = {{'(', '(', ')'}, {')', ')', ')'}};
        // Path: ( -> ( -> ) -> ) -> ) - balance: 1, 2, 1, 0, -1 (invalid)
        if (sol.hasValidPath(grid8) == false) testsPassed++;
        else System.out.println("Test 8 FAILED: Expected false");

        // Test 9: Another valid scenario check
        char[][] grid9 = {{'(', ')', '(', ')'}, {')', '(', ')', '('}};
        // Path length: 2+4-1 = 5 (odd) - should be false
        if (sol.hasValidPath(grid9) == false) testsPassed++;
        else System.out.println("Test 9 FAILED: Expected false for odd length");

        // Test 10: 3x3 grid with even path length 5 (even)
        char[][] grid10 = {{'(', '(', ')'}, {'(', ')', ')'}, {'(', '(', ')'}};
        // Path length: 3+3-1 = 5 (odd) - impossible
        if (sol.hasValidPath(grid10) == false) testsPassed++;
        else System.out.println("Test 10 FAILED: Expected false for 3x3");

        // Test 11: Larger valid grid attempt
        char[][] grid11 = {{'(', ')', '(', ')'}, {'(', '(', ')', ')'}, 
                           {')', ')', '(', ')'}, {'(', '(', ')', ')'}};
        // Path length: 4+4-1=7 (odd) - false
        if (sol.hasValidPath(grid11) == false) testsPassed++;
        else System.out.println("Test 11 FAILED: Expected false");

        // Test 12: Check balance tracking - simple case
        char[][] grid12 = {{'(', ')'}, {'(', ')'}};
        // dp[0][0][1] = true (after first '(')
        // Can reach (0,1) or (1,0) with balance 1
        // (0,1) = ')' -> balance 0
        // (1,0) = '(' -> balance 2
        // Cannot reach (1,1) with balance 0
        if (sol.hasValidPath(grid12) == false) testsPassed++;
        else System.out.println("Test 12 FAILED: Expected false");

        System.out.println("\nTests Passed: " + testsPassed + "/" + totalTests);
    }
}
