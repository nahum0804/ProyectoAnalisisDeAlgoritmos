import java.util.*;

/**
 * Bron-Kerbosch algorithm to find the maximum clique in a graph.
 * The algorithm uses a recursive approach to explore all the possible cliques in the graph.
 */
public class BronKerboschAlgorithm {
    private Set<Vertex> maxClique;
    private Graph graph;
    private static int a = 0; // Assignments
    private static int c = 0; // Comparisons

    /**
     * Create a new instance of the first algorithm to find the maximum clique in a graph.
     *
     * @param graph the graph.
     */
    public BronKerboschAlgorithm(Graph graph) {
        this.maxClique = new HashSet<>();
        this.graph = graph;
    }

    /**
     * Find the maximum clique in a graph.
     */
    public void findMaxClique() {
        Set<Vertex> verticesSet = new HashSet<>(graph.getVertices().values());
        a++;

        bronKerbosch(verticesSet, new HashSet<>(), new HashSet<>());
        a++;
    }

    /**
     * Bron-Kerbosch algorithm to find the maximum clique in a graph.
     *
     * @param candidates the set of candidate vertices.
     * @param selected   the set of selected vertices.
     * @param excluded   the set of excluded vertices.
     */
    private void bronKerbosch(Set<Vertex> candidates, Set<Vertex> selected, Set<Vertex> excluded) {
        if (candidates.isEmpty() && excluded.isEmpty()) {
            c++;
            if (selected.size() > maxClique.size()) {
                c++;
                maxClique = new HashSet<>(selected);
                a++;
            }
            return;
        }

        List<Vertex> candidatesCopy = new ArrayList<>(candidates);
        a++;
        for (Vertex v : candidatesCopy) {
            List<Vertex> neighbors = graph.getVertices().get(v.getLabel()).getAdjacentVertices();
            a++;
            bronKerbosch(intersect(candidates, new HashSet<>(neighbors)), union(selected, v), intersect(excluded, new HashSet<>(neighbors)));
            candidates.remove(v);
            a++;
            excluded.add(v);
            a++;
        }
    }

    /**
     * Check if a set of vertices forms a clique.
     *
     * @param set1 the set of vertices to check.
     * @param set2 the set of vertices to check.
     * @return true if the set of vertices forms a clique, false otherwise.
     */
    private Set<Vertex> intersect(Set<Vertex> set1, Set<Vertex> set2) {
        Set<Vertex> intersection = new HashSet<>(set1);
        a++;
        intersection.retainAll(set2);
        return intersection;
    }

    /**
     * Check if a set of vertices forms a clique.
     *
     * @param set1 the set of vertices to check.
     * @param vertex the vertex to check.
     * @return true if the set of vertices forms a clique, false otherwise.
     */
    private Set<Vertex> union(Set<Vertex> set1, Vertex vertex) {
        Set<Vertex> union = new HashSet<>(set1);
        a++;
        union.add(vertex);
        return union;
    }

    /**
     * Get the maximum clique in the graph.
     *
     * @return the maximum clique in the graph.
     */
    public Set<Vertex> getMaxClique() {
        return maxClique;
    }

    /**
     * Get the maximum size of the clique.
     *
     * @return the maximum size of the clique.
     */
    public int getMaxSize() {
        return maxClique.size();
    }

    /**
     * Start the algorithm to find the maximum clique in a graph.
     *
     * @param numero the number of vertices in the graph.
     */
    public static void start(int numero) {
        Graph graph = new Graph();
        graph.createGraph(numero);

        BronKerboschAlgorithm bronKerboschAlgorithm = new BronKerboschAlgorithm(graph);
        bronKerboschAlgorithm.findMaxClique();

        System.out.print("Clique máximo: ");
        for (Vertex vertex : bronKerboschAlgorithm.getMaxClique()) {
            System.out.print(vertex.getLabel() + " ");
        }
        System.out.println("\nTamaño del clique máximo: " + bronKerboschAlgorithm.getMaxSize());

        System.out.println("\nTotal assignments: " + a);
        System.out.println("Total comparisons: " + c);
    }
}