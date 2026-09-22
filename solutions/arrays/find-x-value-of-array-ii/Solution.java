/**
 * LeetCode Problem #3525: Find X Value of Array II
 * Difficulty: Hard
 * 
 * Segment Tree Approach:
 * - Each node stores the product of its segment and a count matrix
 * - count[node][in][out] = number of prefixes that transform remainder 'in' into 'out'
 * - For each query, use the segment tree to efficiently answer range queries
 */
public class Solution {

    private int k;
    private int size;

    // Product of every segment
    private int[] product;

    /*
     * For every node:
     *
     * count[node][in][out]
     *
     * = number of non-empty prefixes of this segment
     *   which transform remainder 'in' into remainder 'out'.
     *
     * Stored as one flat array:
     *
     * index = node * (k*k) + in*k + out
     */
    private int[] count;

    private int K2;

    // Temporary arrays used by each query
    private int[] leftNodes = new int[64];
    private int[] rightNodes = new int[64];

    private int leafBase(int node) {
        return node * K2;
    }

    private void setLeaf(int node, int value) {

        int v = value % k;
        product[node] = v;

        int base = leafBase(node);

        // Clear leaf
        for (int i = 0; i < K2; i++) {
            count[base + i] = 0;
        }

        // One-element prefix
        for (int in = 0; in < k; in++) {
            int out = (in * v) % k;
            count[base + in * k + out] = 1;
        }
    }

    /*
     * Merge:
     *
     * left + right
     */
    private void merge(int node) {

        int left = node << 1;
        int right = left | 1;

        product[node] =
                (product[left] * product[right]) % k;

        int resultBase = leafBase(node);
        int leftBase = leafBase(left);
        int rightBase = leafBase(right);

        for (int in = 0; in < k; in++) {

            int middle = (in * product[left]) % k;

            int row = in * k;
            int rightRow = middle * k;

            for (int out = 0; out < k; out++) {

                count[resultBase + row + out] =
                        count[leftBase + row + out]
                        + count[rightBase + rightRow + out];
            }
        }
    }

    private void build(int[] nums) {

        size = 1;

        while (size < nums.length) {
            size <<= 1;
        }

        product = new int[size << 1];

        K2 = k * k;

        count = new int[(size << 1) * K2];

        // Leaves
        for (int i = 0; i < size; i++) {

            int node = size + i;

            if (i < nums.length) {
                setLeaf(node, nums[i]);
            } else {
                // Empty/padding segment
                product[node] = 1 % k;
            }
        }

        // Internal nodes
        for (int node = size - 1; node >= 1; node--) {
            merge(node);
        }
    }

    private void update(int index, int value) {

        int node = size + index;

        setLeaf(node, value);

        node >>= 1;

        while (node >= 1) {
            merge(node);
            node >>= 1;
        }
    }

    /*
     * Returns the number of prefixes of nums[start..n-1]
     * whose product % k == x.
     *
     * We don't need to merge complete matrices here.
     *
     * We simply walk through the selected segment-tree nodes
     * from left to right while maintaining the current remainder.
     */
    private int query(int start, int n, int x) {

        int left = start + size;
        int right = n + size;

        int leftCount = 0;
        int rightCount = 0;

        // Decompose [start, n)
        while (left < right) {

            if ((left & 1) == 1) {
                leftNodes[leftCount++] = left++;
            }

            if ((right & 1) == 1) {
                rightNodes[rightCount++] = --right;
            }

            left >>= 1;
            right >>= 1;
        }

        /*
         * Product starts at 1.
         *
         * We process all selected nodes from left to right.
         */
        int currentRemainder = 1 % k;
        int answer = 0;

        // Left-side nodes are already in left-to-right order
        for (int i = 0; i < leftCount; i++) {

            int node = leftNodes[i];

            int base = leafBase(node);

            answer += count[
                    base + currentRemainder * k + x
            ];

            currentRemainder =
                    (currentRemainder * product[node]) % k;
        }

        // Right-side nodes were collected right-to-left
        for (int i = rightCount - 1; i >= 0; i--) {

            int node = rightNodes[i];

            int base = leafBase(node);

            answer += count[
                    base + currentRemainder * k + x
            ];

            currentRemainder =
                    (currentRemainder * product[node]) % k;
        }

        return answer;
    }

    public int[] resultArray(
            int[] nums,
            int k,
            int[][] queries) {

        this.k = k;

        build(nums);

        int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            /*
             * Updates persist between queries.
             */
            if (nums[index] != value) {
                nums[index] = value;
                update(index, value);
            }

            /*
             * Every possible remaining array is:
             *
             * nums[start..end]
             *
             * where end ranges from start to n-1.
             *
             * So we count prefixes of nums[start..n-1].
             */
            result[q] = query(start, nums.length, x);
        }

        return result;
    }
}
