import java.util.*;

public class Item3 {
    
    private int vertices;
    private List<List<Integer>> adjList;

    public Item3(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    private boolean isCyclicUtil(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;
        List<Integer> children = adjList.get(vertex);
        for (Integer child : children) {
            if (!visited[child]) {
                if (isCyclicUtil(child, visited, vertex)) {
                    return true;
                }
            } else if (child != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean isCycle() {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of vertices: ");
        int vertices = scanner.nextInt();
        
        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();
        
        Item3 graph = new Item3(vertices);
        
        System.out.println("Enter the edges:");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }
        
        scanner.close();

        if (graph.isCycle()) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}
