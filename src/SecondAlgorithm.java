import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class SecondAlgorithm {
    private int maxSize;
    private List<Vertex> maxClique;
    private Graph graph;

    //Asignaciones
    private static int a = 0;
    //Comparaciones
    private static int c = 0;
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
        List<Vertex> vertices = new ArrayList<>(graph.getVertices().values());
        a++;
        List<Vertex> currentClique = new ArrayList<>();
        a++;
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
            c++;
            if (isClique(currentClique)) {
                c++;
                if (currentClique.size() > maxSize) {
                    c++;
                    maxSize = currentClique.size();
                    a++;
                    maxClique = new ArrayList<>(currentClique);
                    a++;
                }
            }
            return;
        }

        Vertex v = vertices.get(index);
        a++;
        // Intenta agregar el vértice actual al clique
        currentClique.add(v);
        a++;
        // Si el clique actual sigue siendo un clique válido, continúa explorando
        if (isClique(currentClique)) {
            c++;
            deepFirstSearch(vertices, currentClique, index + 1);
        }
        // Elimina el vértice actual del clique y continúa explorando sin él
        currentClique.remove(v);
        a++;
        deepFirstSearch(vertices, currentClique, index + 1);
    }

    /**
     * Check if a list of vertices is a clique in a graph.
     *
     * @param clique the list of vertices.
     * @return true if the list of vertices is a clique in the graph, false otherwise.
     */
    private boolean isClique(List<Vertex> clique) {
        //asignacion i = 0
        a++;
        for (int i = 0; i < clique.size(); i++) {
            a++;
            c++;
            for (int j = i + 1; j < clique.size(); j++) {
                a += 2;
                c++;
                if (!graph.hasEdge(clique.get(i).getLabel(), clique.get(j).getLabel())) {
                    c+=2;
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
     * Main method to execute the algorithm.
     *
     * @param numero
     */
    public static void start(int numero) {

        // Crear el grafo
        Graph graph = new Graph();
        graph.createGraph(numero);

        SecondAlgorithm secondAlgorithm = new SecondAlgorithm(graph);
        secondAlgorithm.findMaxClique();

        //System.out.println("Tamaño del clique máximo: " + secondAlgorithm.getMaxSize());
        System.out.print("Clique máximo: ");
        //System.out.println("Vértices del clique máximo: " + secondAlgorithm.getMaxClique());
        //
        for (Vertex vertex : secondAlgorithm.getMaxClique()) {
            System.out.print(vertex.getLabel() + " ");
        }

        System.out.println("\nTamaño del clique máximo: " + secondAlgorithm.getMaxSize());

        System.out.println("\nTotal assignments: "+ a);
        System.out.println("Total comparisons: "+ c);
    }
}

