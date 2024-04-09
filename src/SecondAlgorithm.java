import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class SecondAlgorithm {
    private int maxSize;
    private List<Vertex> maxClique;
    private Graph graph;

    /**
     * Create a new instance of the second algorithm to find the maximum clique in a graph.
     *
     * @param graph the graph.
     */
    public SecondAlgorithm(Graph graph) {
        this.maxSize = 0;
        this.maxClique = new ArrayList<>();
        this.graph = graph;
    }

    /**
     * Find the maximum clique in a graph.
     */
    public void findMaxClique() {
        List<Vertex> vertices = new ArrayList<>(graph.getVertices().keySet());
        List<Vertex> currentClique = new ArrayList<>();
        deepFirstSearch(vertices, currentClique, 0);
    }

    /**
     * Depth-first search to find the maximum clique in a graph.
     *
     * @param vertices      the list of vertices.
     * @param currentClique the current clique.
     * @param index         the current index.
     */
    private void deepFirstSearch(List<Vertex> vertices, List<Vertex> currentClique, int index) {
        if (index == vertices.size()) {
            if (isClique(currentClique)) {
                if (currentClique.size() > maxSize) {
                    maxSize = currentClique.size();
                    maxClique = new ArrayList<>(currentClique);
                }
            }
            return;
        }

        Vertex v = vertices.get(index);
        // Intenta agregar el vértice actual al clique
        currentClique.add(v);
        // Si el clique actual sigue siendo un clique válido, continúa explorando
        if (isClique(currentClique)) {
            deepFirstSearch(vertices, currentClique, index + 1);
        }
        // Elimina el vértice actual del clique y continúa explorando sin él
        currentClique.remove(v);
        deepFirstSearch(vertices, currentClique, index + 1);
    }

    /**
     * Check if a list of vertices is a clique in a graph.
     *
     * @param clique the list of vertices.
     * @return true if the list of vertices is a clique in the graph, false otherwise.
     */
    private boolean isClique(List<Vertex> clique) {
        for (int i = 0; i < clique.size(); i++) {
            for (int j = i + 1; j < clique.size(); j++) {
                if (!graph.hasEdge(clique.get(i).getLabel(), clique.get(j).getLabel())) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Get the maximum size of the clique.
     *
     * @return the maximum size of the clique.
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * Get the maximum clique.
     *
     * @return the maximum clique.
     */
    public List<Vertex> getMaxClique() {
        return maxClique;
    }

    /**
     * Main method to find the maximum clique in a graph.
     *
     * @param args the input arguments.
     */
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.createGraph();

        SecondAlgorithm secondAlgorithm = new SecondAlgorithm(graph);
        secondAlgorithm.findMaxClique();

        //System.out.println("Tamaño del clique máximo: " + secondAlgorithm.getMaxSize());
        System.out.print("Clique máximo: ");
        //System.out.println("Vértices del clique máximo: " + secondAlgorithm.getMaxClique());
        //
        for (Vertex vertex : secondAlgorithm.getMaxClique()) {
            System.out.println(vertex.getLabel());
        }
    }
}

