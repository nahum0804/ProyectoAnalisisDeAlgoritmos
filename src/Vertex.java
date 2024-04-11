import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private List<Vertex> adjacentVertices;

    /**
     * Create a new vertex.
     *
     * @param name the label of the vertex.
     */
    public Vertex(String name) {
        this.name = name;
        this.adjacentVertices = new ArrayList<>();
    }

    /**
     * Get the label of the vertex.
     *
     * @return the label of the vertex.
     */
    public String getLabel() {
        return name;
    }

    /**
     * Add an adjacent vertex.
     *
     * @param vertex the adjacent vertex to add.
     */
    public void addAdjacentVertex(Vertex vertex) {
        adjacentVertices.add(vertex);
    }

    /**
     * Remove an adjacent vertex.
     *
     * @param vertex the adjacent vertex to remove.
     */
    public void removeAdjacentVertex(Vertex vertex) {
        adjacentVertices.remove(vertex);
    }

    /**
     * Remove this vertex from the adjacency lists of adjacent vertices.
     */
    public void remove(Vertex v) {
        for (Vertex adjacentVertex : adjacentVertices) {
            adjacentVertex.adjacentVertices.remove(v);
        }
    }

    /**
     * Check if a vertex is adjacent to this vertex.
     *
     * @param vertex the vertex to check adjacency with.
     * @return true if the specified vertex is adjacent to this vertex, false otherwise.
     */
    public boolean isAdjacent(Vertex vertex) {
        return adjacentVertices.contains(vertex);
    }
}
