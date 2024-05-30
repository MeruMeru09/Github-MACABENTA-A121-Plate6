import java.util.Scanner;

public class Item6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numberOfVertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int numberOfEdges = scanner.nextInt();

        int[][] adjacencyMatrix = new int[numberOfVertices][numberOfVertices];

        System.out.println("Enter the pairs of vertices for each edge:");
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            adjacencyMatrix[vertex1][vertex2]++;

            System.out.println("Is this edge directed or a loop? (yes/no):");
            String directed = scanner.next();
            if (directed.equalsIgnoreCase("no")) {
                adjacencyMatrix[vertex2][vertex1]++;
            }
        }

        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
