import java.util.*;

public class Item1 {

    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of edges:");
        int numEdges = input.nextInt();
        
        System.out.println("Enter the edges:");
        for (int i = 0; i < numEdges; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            addEdge(u, v);
        }

        if (graph.isEmpty()) {
            System.out.println("The graph has no edges.");
            return;
        }

        int connectedComponents = 0;
        for (Integer node : graph.keySet()) {
            if (!visited.contains(node)) {
                connectedComponents++;
                dfs(node);
            }
        }

        if (connectedComponents == 1) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + connectedComponents);
        }
    }

    private static void addEdge(int u, int v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private static void dfs(int node) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                for (int neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
