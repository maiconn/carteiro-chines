import java.io.File;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("-- Programa para eulerizar um grafo e imprimir o ciclo euleriano --");
		System.out.println("Deseja utilizar o exemplo do trabalho ou criar um novo grafo?");
		System.out.println("Digite 1 para exemplo pronto ou 2 para criar um novo grafo");
		int opcao = Integer.parseInt(scanner.nextLine());
		if (opcao == 1) {
			scanner = new Scanner(new File("arestas.txt"));
		} 

		System.out.println("Quantos v�rtices ser�o utilizados no total? Digite:");
		int qtdVertices = Integer.parseInt(scanner.nextLine());

		System.out.println("Abaixo digite as arestas que o grafo ir� conter:");
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
