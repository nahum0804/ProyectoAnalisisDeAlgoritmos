import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        for(int numero = 1; numero <= 10; numero++){
            List<String> mensajes = new ArrayList<>();
            mensajes.add("");
            mensajes.add("5 Vertices y 6 Arcos");
            mensajes.add("10 Vertices y 12 Arcos");
            mensajes.add("20 Vertices y 20 Arcos");
            mensajes.add("20 Vertices y 30 Arcos");
            mensajes.add("20 Vertices y 40 Arcos");
            mensajes.add("20 Vertices y 50 Arcos");
            mensajes.add("20 Vertices y 80 Arcos");
            mensajes.add("40 Vertices y 120 Arcos");
            mensajes.add("60 Vertices y 240 Arcos");
            mensajes.add("80 Vertices y 400 Arcos");

            System.out.println(" ------------------------------------ ");
            System.out.println(mensajes.get(numero));
            System.out.println(" ------------------------------------ ");
            // First Algorithm to find the maximum clique in a graph
            System.out.println("First Algorithm to find the maximum clique in a graph");
            System.out.println(" ------------------------------------ ");
            BronKerboschAlgorithm.start(numero);
            System.out.println(" ------------------------------------ \n \n");

            System.out.println("SECOND ALGORITHM TO FIND THE MAXIMUM CLIQUE IN A GRAPH");
            System.out.println(" ------------------------------------ ");
            DeepFirstAlgorithm.start(numero);
            System.out.println(" ------------------------------------ \n\n");


        }
    }
}
