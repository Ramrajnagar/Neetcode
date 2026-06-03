

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) return;
        
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        // Step 1: Add all treasure chests (0) to the queue
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    queue.add(new int[]{r, c});
                }
            }
        }
        
        // Directions for moving Up, Down, Left, Right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Step 2: Multi-source BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            
            for (int[] dir : directions) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                
                // If the neighbor is valid and is an unvisited land cell (INF)
                if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && grid[nextR][nextC] == 2147483647) {
                    // Update distance to current cell's distance + 1
                    grid[nextR][nextC] = grid[r][c] + 1;
                    // Push neighbor to queue to explore its neighbors later
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
    }
}