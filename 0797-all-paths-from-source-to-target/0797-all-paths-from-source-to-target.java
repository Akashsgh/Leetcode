import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        
        // Every path must start at node 0
        currentPath.add(0);
        
        backtrack(0, graph, currentPath, result);
        return result;
    }

    private void backtrack(int node, int[][] graph, List<Integer> currentPath, List<List<Integer>> result) {
        
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for (int nextNode : graph[node]) {
            currentPath.add(nextNode);
            backtrack(nextNode, graph, currentPath, result); 
            currentPath.remove(currentPath.size() - 1); 
        }
    }
}