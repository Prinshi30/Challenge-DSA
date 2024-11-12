
class Solution {
    // Define directions for DFS traversal (right, down, left, up)
    private final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       ArrayList<List<Integer>> res= new ArrayList<>();
        
        // Check if the input grid is empty
        if(heights == null || heights.length == 0 || heights[0].length == 0){
            return res;
        }
        
        int row = heights.length, col = heights[0].length;
        
        // Create two grids to mark cells that can reach the Pacific and Atlantic oceans
        boolean[][] pacific = new boolean [row][col];
        boolean[][] atlantic= new boolean[row][col];

        // Start DFS from cells adjacent to the Pacific Ocean (left and top borders)
        for(int i = 0; i < col; i++){
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);           // Top border (Pacific)
            dfs(heights, row - 1, i, Integer.MIN_VALUE, atlantic);    // Bottom border (Atlantic)
        }
        for(int i = 0; i < row; i++){
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);           // Left border (Pacific)
            dfs(heights, i, col - 1, Integer.MIN_VALUE, atlantic);    // Right border (Atlantic)
        }

        // Collect cells that can flow to both oceans
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                // If both pacific and atlantic grids mark the cell as reachable, add to result
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));  // Fixed "Array" to "Arrays"
                }
            }
        }
        
        return res;
    }

    // Helper function to perform DFS to mark reachable cells
    public void dfs(int[][] heights, int i, int j, int prev, boolean[][] ocean) {
        // Stop if out of grid boundaries or if current height is less than previous
        if(i < 0 || i >= heights.length || j < 0 || j >= heights[0].length) return;
        if(heights[i][j] < prev || ocean[i][j]) return;

        // Mark cell as reachable for the current ocean
        ocean[i][j] = true;

        // Explore all four directions (up, down, left, right)
        for(int[] d : dir){
            dfs(heights, i + d[0], j + d[1], heights[i][j], ocean);
        }
    }
}
