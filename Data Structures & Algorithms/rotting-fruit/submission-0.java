

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Scan the grid to count fresh fruits and locate initial rotten fruits
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c}); // Multi-source starting points
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }
        
        // If there are no fresh fruits to begin with, 0 minutes have elapsed
        if (freshCount == 0) return 0;
        
        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Step 2: Level-by-level BFS simulation
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            minutes++; // Increment time for the upcoming wave of rotting
            
            // Process all rotten fruits currently at this level
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                
                for (int[] dir : directions) {
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];
                    
                    // If neighbor is within bounds and is a fresh fruit
                    if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && grid[nextR][nextC] == 1) {
                        grid[nextR][nextC] = 2; // Infect the fruit
                        freshCount--;           // Decrement total fresh count
                        queue.add(new int[]{nextR, nextC});
                    }
                }
            }
        }
        
        // Step 3: If fresh fruits still remain, return -1; otherwise, return the minutes
        return freshCount == 0 ? minutes : -1;
    }
}