import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* A class to represent a graph
 */
public class Graph {
    private Map<Vertex, List<Vertex>> vertices;

    /**
     * Create a new graph.
     */
    public Graph() {
        vertices = new HashMap<>();
    }

    /**
     * Add a new vertex to the graph.
     *
     * @param label the new vertex name.
     */
    void addVertex(String label) {
        vertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    /**
     * Remove a vertex from the graph.
     *
     * @param label the vertex name to remove.
     */
    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        vertices.values().stream().forEach(e -> e.remove(v));
        vertices.remove(new Vertex(label));
    }

/**
     * Add an edge to the graph.
     *
     * @param label1 the first vertex name.
     * @param label2 the second vertex name.
     */
    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        // Obtener o inicializar la lista de adyacencia para v1
        List<Vertex> adjacentVerticesV1 = vertices.computeIfAbsent(v1, k -> new ArrayList<>());
        adjacentVerticesV1.add(v2);

        // Obtener o inicializar la lista de adyacencia para v2
        List<Vertex> adjacentVerticesV2 = vertices.computeIfAbsent(v2, k -> new ArrayList<>());
        adjacentVerticesV2.add(v1);
    }

    /**
     * Remove an edge from the graph.
     *
     * @param label1 the first vertex name.
     * @param label2 the second vertex name.
     */
    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = vertices.get(v1);
        List<Vertex> eV2 = vertices.get(v2);
        if (eV1 != null) {
            eV1.remove(v2);
        }
        if (eV2 != null) {
            eV2.remove(v1);
        }
    }

    /**
     * Initialize the graph with some example vertices and edges.
     *
     * @return the graph itself.
     */
    void createGraph() {
        addVertex("Bob");
        addVertex("Alice");
        addVertex("Mark");
        addVertex("Rob");
        addVertex("Maria");
        addEdge("Bob", "Alice");
        addEdge("Bob", "Rob");
        addEdge("Alice", "Mark");
        addEdge("Rob", "Mark");
        addEdge("Alice", "Maria");
        addEdge("Rob", "Maria");
    }

    /**
    * Check if there is an edge between two vertices.
    *
    * @param label1 the first vertex name.
    * @param label2 the second vertex name.
    *
    * @return true if there is an edge between the two vertices, false otherwise.
    */
    public boolean hasEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> adjacentVerticesV1 = vertices.get(v1);
        List<Vertex> adjacentVerticesV2 = vertices.get(v2);
        return adjacentVerticesV1 != null && adjacentVerticesV2 != null &&
                adjacentVerticesV1.contains(v2) && adjacentVerticesV2.contains(v1);
    }

    /**
     * Get the graph vertices.
     *
     * @return the graph vertices.
     */
    public Map<Vertex, List<Vertex>> getVertices() {
        return vertices;
    }
}
