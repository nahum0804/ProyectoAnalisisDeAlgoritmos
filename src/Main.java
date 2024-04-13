import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Elige un número según el tamaño grafo que deseas ver");
        System.out.println("1) 5 Vertices y 6 Arcos     2) 10 Vertices y 12 Arcos   3) 20 Vertices y 20 Arcos     4) 20 Vertices y 30 Arcos     5) 20 Vertices y 40 Arcos");
        System.out.println("6) 20 Vertices y 50 Arcos   7) 20 Vertices y 80 Arcos   8) 40 Vertices y 120 Arcos    9) 60 Vertices y 240 Arcos    10) 80 Vertices y 400 Arcos");

        Scanner scanner = new Scanner(System.in);
        // Pedir al usuario que ingrese un número
        System.out.print("Ingrese un número entero: ");
        // Leer el número ingresado por el usuario
        int numero = scanner.nextInt();
        // Mostrar el número ingresado
        System.out.println("El número ingresado es: " + numero);
        // Cerrar el objeto Scanner al finalizar su uso
        scanner.close();


    // First Algorithm to find the maximum clique in a graph
        System.out.println("First Algorithm to find the maximum clique in a graph");
        System.out.println(" ------------------------------------ ");
        FirstAlgorithm.start(numero);
        System.out.println(" ------------------------------------ \n \n");

        System.out.println("SECOND ALGORITHM TO FIND THE MAXIMUM CLIQUE IN A GRAPH");
        System.out.println(" ------------------------------------ ");
        SecondAlgorithm.start(numero);
        System.out.println(" ------------------------------------ ");
    }
}
