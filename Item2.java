import java.util.*;

public class Item2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = input.nextInt();

        int[][] adjacencyMatrix = new int[vertices][vertices];
        System.out.println("Input adjacency matrix: ");

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = input.nextInt();
            }
        }

        Map<String, Integer> edgeCountMap = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    String edge = i + "-" + j;
                    edgeCountMap.put(edge, edgeCountMap.getOrDefault(edge, 0) + adjacencyMatrix[i][j]);
                }
            }
        }

        System.out.println("list of edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        input.close();
    }
}
