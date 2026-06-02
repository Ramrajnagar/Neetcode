

public class Solution {
    public String foreignDictionary(String[] words) {
        // Step 1: Initialize the graph adjacency list for all unique characters
        Map<Character, Set<Character>> adj = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        // Step 2: Build the directed graph by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            // Check Prefix Rule: If w1 is longer than w2 but matches up to minLen, it's invalid
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }

            // Find the first character mismatch to establish an edge
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break; // Crucial: skip subsequent characters as they provide no order info
                }
            }
        }

        // Step 3: DFS Topological Sort tracking with a state map
        // 0 = unvisited, 1 = visiting, 2 = visited
        Map<Character, Integer> visited = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (char c : adj.keySet()) {
            if (hasCycle(c, adj, visited, sb)) {
                return ""; // Cycle detected, return an empty string
            }
        }

        // Step 4: The post-order traversal yields the reverse sequence, so flip it
        return sb.reverse().toString();
    }

    private boolean hasCycle(char c, Map<Character, Set<Character>> adj, 
                             Map<Character, Integer> visited, StringBuilder sb) {
        // If currently visiting this node in the current path, a cycle exists
        if (visited.getOrDefault(c, 0) == 1) return true;
        // If already completely processed, skip it safely
        if (visited.getOrDefault(c, 0) == 2) return false;

        // Mark node as 'Visiting'
        visited.put(c, 1);

        // Recurse for all dependencies
        for (char neighbor : adj.get(c)) {
            if (hasCycle(neighbor, adj, visited, sb)) {
                return true;
            }
        }

        // Mark node as 'Visited' and add to the post-order sequence
        visited.put(c, 2);
        sb.append(c);
        
        return false;
    }
}