import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Item4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Map<Integer, Integer> degreeMap = new HashMap<>();
        
        System.out.print("Enter number of edges: ");
        int numberOfEdges = scanner.nextInt();
        
        System.out.println("Enter the pairs of vertices for each edge:");
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            
            degreeMap.put(vertex1, degreeMap.getOrDefault(vertex1, 0) + 1);
            
            degreeMap.put(vertex2, degreeMap.getOrDefault(vertex2, 0) + 1);
        }
        
        System.out.println("Degrees of vertices:");
        for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + ": " + entry.getValue());
        }
        
        scanner.close();
    }
}
