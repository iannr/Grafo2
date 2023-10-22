package Grafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o nome do arquivo de dados: ");
        String filename = scanner.nextLine();

        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            int V = fileScanner.nextInt();
            int E = fileScanner.nextInt();
            Graph graph = new Graph(V);

            for (int i = 0; i < E; i++) {
                int v = fileScanner.nextInt();
                int w = fileScanner.nextInt();
                graph.addEdge(v, w);
            }

            System.out.print("Informe o número do vértice a partir do qual deseja iniciar a busca: ");
            int startVertex = scanner.nextInt();

            boolean[] visited = new boolean[V];
            System.out.print("Resultado da busca em profundidade a partir do vértice " + startVertex + ": ");
            graph.DFS(startVertex, visited);

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }

}
