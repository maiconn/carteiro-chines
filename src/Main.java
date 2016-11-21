import java.io.File;
import java.util.Scanner;

/**
 * 
 * @author Maicon Machado Gerardi da Silva
 * @author Débora Missiaggia Ghilardi
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("-- Programa para eulerizar um grafo e imprimir o ciclo euleriano --");
		System.out.println("Para este programa foi utilizado o grafo exemplo do trabalho... (conforme grafo.png nesse projeto)");
		System.out.println("");

		Scanner scanner = new Scanner(new File("arestas.txt"));

		int qtdVertices = Integer.parseInt(scanner.nextLine());

		Grafo grafo = new Grafo(qtdVertices);
		while (true) {
			String[] numeros = scanner.nextLine().split(" ");
			int origem = Integer.parseInt(numeros[0]);
			int destino = Integer.parseInt(numeros[1]);
			int valor = Integer.parseInt(numeros[2]);
			if (origem == 0 && destino == 0 && valor == 0) {
				break;
			}

			grafo.criarAresta(origem, destino, valor);
		}

		System.out.println("Resultado:");
		grafo.carteiroChines();

		scanner.close();
	}
}
