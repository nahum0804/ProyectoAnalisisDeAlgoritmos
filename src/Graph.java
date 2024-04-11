import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class to represent a graph
 */
public class Graph {
    private Map<String, Vertex> vertices;

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
        vertices.putIfAbsent(label, new Vertex(label));
    }

    /**
     * Remove a vertex from the graph.
     *
     * @param label the vertex name to remove.
     */
    void removeVertex(String label) {
        Vertex v = vertices.remove(label);
        if (v != null) {
            vertices.values().forEach(adjacentVertices -> adjacentVertices.remove(v));
        }
    }

    /**
     * Add an edge to the graph.
     *
     * @param label1 the first vertex name.
     * @param label2 the second vertex name.
     */
    void addEdge(String label1, String label2) {
        Vertex v1 = vertices.get(label1);
        Vertex v2 = vertices.get(label2);
        if (v1 != null && v2 != null) {
            v1.addAdjacentVertex(v2);
            v2.addAdjacentVertex(v1);
        }
    }

    /**
     * Remove an edge from the graph.
     *
     * @param label1 the first vertex name.
     * @param label2 the second vertex name.
     */
    void removeEdge(String label1, String label2) {
        Vertex v1 = vertices.get(label1);
        Vertex v2 = vertices.get(label2);
        if (v1 != null && v2 != null) {
            v1.removeAdjacentVertex(v2);
            v2.removeAdjacentVertex(v1);
        }
    }

    /**
     * Initialize the graph with some example vertices and edges.
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
        addEdge("Rob", "Alice");
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
        Vertex v1 = vertices.get(label1);
        Vertex v2 = vertices.get(label2);
        return v1 != null && v2 != null && v1.isAdjacent(v2);
    }

    /**
     * Get the graph vertices.
     *
     * @return the graph vertices.
     */
    public Map<String, Vertex> getVertices() {
        return vertices;
    }
}
