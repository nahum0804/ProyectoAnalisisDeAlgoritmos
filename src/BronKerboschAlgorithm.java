import java.util.*;

public class BronKerboschAlgorithm {
    private Set<Vertex> maxClique;
    private Graph graph;
    private static int a = 0; // Assignments
    private static int c = 0; // Comparisons

    public BronKerboschAlgorithm(Graph graph) {
        this.maxClique = new HashSet<>();
        this.graph = graph;
    }

    public void findMaxClique() {
        Set<Vertex> verticesSet = new HashSet<>(graph.getVertices().values());
        bronKerbosch(verticesSet, new HashSet<>(), new HashSet<>());
    }

    private void bronKerbosch(Set<Vertex> candidates, Set<Vertex> selected, Set<Vertex> excluded) {
        if (candidates.isEmpty() && excluded.isEmpty()) {
            c++;
            if (selected.size() > maxClique.size()) {
                maxClique = new HashSet<>(selected);
                a++;
            }
            return;
        }

        List<Vertex> candidatesCopy = new ArrayList<>(candidates);
        for (Vertex v : candidatesCopy) {
            List<Vertex> neighbors = graph.getVertices().get(v.getLabel()).getAdjacentVertices();
            bronKerbosch(intersect(candidates, new HashSet<>(neighbors)), union(selected, v), intersect(excluded, new HashSet<>(neighbors)));
            candidates.remove(v);
            excluded.add(v);
        }
    }

    private Set<Vertex> intersect(Set<Vertex> set1, Set<Vertex> set2) {
        Set<Vertex> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    private Set<Vertex> union(Set<Vertex> set1, Vertex vertex) {
        Set<Vertex> union = new HashSet<>(set1);
        union.add(vertex);
        return union;
    }

    public Set<Vertex> getMaxClique() {
        return maxClique;
    }

    public int getMaxSize() {
        return maxClique.size();
    }

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
