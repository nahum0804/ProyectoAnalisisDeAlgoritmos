import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    /**
     * Find the maximum clique in a graph.
     *
     * @param graph the graph.
     * @return the maximum clique in the graph.
    */
    public static Set<Vertex> findMaxClique(Graph graph) {
        Set<Vertex> maxClique = new HashSet<>();
        Set<Vertex> currentClique = new HashSet<>();

        List<Vertex> vertices = new ArrayList<>(graph.getVertices().keySet());
        int n = vertices.size();

        // Testing the vertices
        System.out.println("Vertices: " + vertices);
        System.out.println("n: " + n);

        // Enumerar todos los subconjuntos de vértices
        for (int i = 0; i < (1 << n); i++) {
            currentClique.clear();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    currentClique.add(vertices.get(j));
                }
            }
            // Verificar si el subconjunto forma un clique
            if (isClique(currentClique, graph)) {
                // Actualizar el clique máximo
                if (currentClique.size() > maxClique.size()) {
                    maxClique = new HashSet<>(currentClique);
                }
            }
        }
        return maxClique;
    }

    public static boolean isClique(Set<Vertex> clique, Graph graph) {
        // Verificar si cada par de vértices en el clique está conectado por una arista
        for (Vertex vertex1 : clique) {
            for (Vertex vertex2 : clique) {
                if (vertex1 != vertex2 && !graph.hasEdge(vertex1.getLabel(), vertex2.getLabel())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Crear el grafo
        Graph graph = new Graph();
        graph.createGraph();

        // Encontrar el clique máximo
        Set<Vertex> maxClique = findMaxClique(graph);
        //System.out.println("Clique máximo:" + maxClique.size());

        // Imprimir el clique máximo
        System.out.println("Clique máximo:");
        for (Vertex vertex : maxClique) {
            System.out.println(vertex.getLabel());
        }
    }

}
