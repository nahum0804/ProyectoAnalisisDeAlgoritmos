import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// FirstAlgorithm.java
/**
 * A class to represent the first algorithm to find the maximum clique in a graph.
 *
 * Apply the BRUTE FORCE ALGORITHM.
 */


public class FirstAlgorithm {
    /**
     * Find the maximum clique in a graph.
     *
     * @param graph the graph.
     * @return the maximum clique in the graph.
     */
    //Assignments
    private static int a = 0;
    //Comparisons
    private static int c = 0;
    public static Set<Vertex> findMaxClique(Graph graph) {
        Set<Vertex> maxClique = new HashSet<>();
        a++;
        Set<Vertex> currentClique = new HashSet<>();
        a++;
        List<Vertex> vertices = new ArrayList<>(graph.getVertices().values());
        a++;
        int n = vertices.size();
        a++;

        // Testing the vertices

        //System.out.println("Vertices: " + vertices);
        //System.out.println("n: " + n);

        // Enumerar todos los subconjuntos de vértices
        a++;
        for (int i = 0; i < (1 << n); i++) {
            c += 2;
            a++;
            currentClique.clear();
            for (int j = 0; j < n; j++) {
                a++;
                c++;
                if ((i & (1 << j)) > 0) {
                    c += 2;
                    currentClique.add(vertices.get(j));
                }
            }
            // Verificar si el subconjunto forma un clique
            if (isClique(currentClique, graph)) {
                c++;
                // Actualizar el clique máximo
                if (currentClique.size() > maxClique.size()) {
                    c++;
                    maxClique = new HashSet<>(currentClique);
                    a++;
                }
            }
        }
        return maxClique;
    }

    /**
     * Check if a set of vertices is a clique in a graph.
     *
     * @param clique the set of vertices.
     * @param graph  the graph.
     * @return true if the set of vertices is a clique in the graph, false otherwise.
     */
    public static boolean isClique(Set<Vertex> clique, Graph graph) {
        // Verificar si cada par de vértices en el clique está conectado por una arista
        for (Vertex vertex1 : clique) {
            for (Vertex vertex2 : clique) {
                if (vertex1 != vertex2 && !graph.hasEdge(vertex1.getLabel(), vertex2.getLabel())) {
                    c+=2;
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Main method.
     *
     * @param args the arguments.
     */
    public static void main(String[] args) {
        // Crear el grafo
        Graph graph = new Graph();
        graph.createGraph();

        // Encontrar el clique máximo
        Set<Vertex> maxClique = findMaxClique(graph);
        //System.out.println("Clique máximo:" + maxClique.size());

        // Imprimir el clique máximo
        System.out.print("Clique máximo: ");
        for (Vertex vertex : maxClique) {
            System.out.print(vertex.getLabel() + " ");
        }
        System.out.println("\nTotal assignments: "+ a);
        System.out.println("Total comparisons: "+ c);
    }
}
