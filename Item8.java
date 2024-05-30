import java.util.*;

public class Item8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices for both graphs: ");
        int numVertices = scanner.nextInt();

        System.out.println("Enter the number of edges for the first graph:");
        int numEdges1 = scanner.nextInt();

        System.out.println("Enter the edges for the first graph:");
        int[][] graph1 = new int[numVertices][numVertices];
        for (int i = 0; i < numEdges1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph1[u][v] = graph1[v][u] = 1;
        }

        System.out.print("Enter the number of edges for the second graph: ");
        int numEdges2 = scanner.nextInt();

        System.out.println("Enter the edges for the second graph:");
        int[][] graph2 = new int[numVertices][numVertices];
        for (int i = 0; i < numEdges2; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph2[u][v] = graph2[v][u] = 1;
        }

        boolean isomorphic = areIsomorphic(graph1, graph2);
        System.out.println(isomorphic ? "The graphs are isomorphic." : "The graphs are not isomorphic.");

        scanner.close();
    }

    private static boolean areIsomorphic(int[][] graph1, int[][] graph2) {
        int n = graph1.length;
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) perm[i] = i;

        do {
            if (checkPermutation(graph1, graph2, perm)) return true;
        } while (nextPermutation(perm));

        return false;
    }

    private static boolean checkPermutation(int[][] graph1, int[][] graph2, int[] perm) {
        int n = graph1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph1[i][j] != graph2[perm[i]][perm[j]]) return false;
            }
        }
        return true;
    }

    private static boolean nextPermutation(int[] perm) {
        int n = perm.length, k = n - 2;
        while (k >= 0 && perm[k] >= perm[k + 1]) k--;
        if (k < 0) return false;
        int l = n - 1;
        while (perm[l] <= perm[k]) l--;
        swap(perm, k, l);
        for (int i = k + 1, j = n - 1; i < j; i++, j--) swap(perm, i, j);
        return true;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}