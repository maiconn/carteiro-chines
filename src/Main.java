import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Quantos vértices serão utilizados no total? Digite:");
		int qtdVertices = Integer.parseInt(scanner.nextLine());

		System.out.println("Abaixo digite as arestas que o grafo irá conter:");
		System.out.println("deve seguir o seguinte formato: [verticeOrigem verticeDestino valorAresta]");
		System.out.println("exemplo: 1 2 10");

		Grafo grafo = new Grafo(qtdVertices);
		while (true) {
			System.out.println("Digite uma aresta: [0 0 0 para finalizar]");

			String[] numeros = scanner.nextLine().split(" ");
			int origem = Integer.parseInt(numeros[0]);
			int destino = Integer.parseInt(numeros[1]);
			int valor = Integer.parseInt(numeros[2]);
			if (origem == 0 && destino == 0 && valor == 0) {
				break;
			}

			grafo.criarAresta(origem, destino, valor);
		}

		grafo.carteiroChines();
		
		scanner.close();
	}
}
