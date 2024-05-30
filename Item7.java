import java.util.*;

public class Item7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int numberOfVertices = scanner.nextInt();

        System.out.print("Enter number of edges: ");
        int numberOfEdges = scanner.nextInt();

        int[][] incidenceMatrix = new int[numberOfVertices][numberOfEdges];

        System.out.println("Enter the pairs of vertices for each edge and the number of times each edge appears:");
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            int multiplicity = scanner.nextInt();
            incidenceMatrix[vertex1][i] = multiplicity;
            incidenceMatrix[vertex2][i] = multiplicity;
        }
        
        System.out.println("Incidence Matrix:");
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfEdges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
