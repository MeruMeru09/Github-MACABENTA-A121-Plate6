import java.util.*;

public class Item5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of edges: ");
        int numberOfEdges = scanner.nextInt();
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        System.out.println("Enter the pairs of vertices for each edge:");
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            
            graph.computeIfAbsent(vertex1, k -> new ArrayList<>()).add(vertex2);
            graph.computeIfAbsent(vertex2, k -> new ArrayList<>()).add(vertex1);
        }
        
        boolean isBipartite = isBipartite(graph);
        if (isBipartite) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
        
        scanner.close();
    }

    public static boolean isBipartite(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> color = new HashMap<>();
        
        for (int node : graph.keySet()) {
            if (!color.containsKey(node)) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(node);
                color.put(node, 0);
                
                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    int currentColor = color.get(current);
                    
                    for (int neighbor : graph.get(current)) {
                        if (!color.containsKey(neighbor)) {
                            color.put(neighbor, 1 - currentColor);
                            queue.offer(neighbor);
                        } else if (color.get(neighbor) == currentColor) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
