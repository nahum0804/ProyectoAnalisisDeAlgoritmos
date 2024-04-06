public class Vertex {
    private String name;

    /**
     * Create a new vertex.
     *
     * @param name the label of the vertex.
     */
    Vertex(String name) {
        this.name = name;
    }

    /**
     * Get the label of the vertex.
     *
     * @return the label of the vertex.
     */
    public String getLabel() {
        return name;
    }
}
