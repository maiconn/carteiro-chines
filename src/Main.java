import java.util.Scanner;

/**
 * 
 * @author Maicon Machado Gerardi da Silva
 * @author Débora Missiaggia Ghilardi
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder str = new StringBuilder();
		str.append("12\n");
		str.append("0 1 10\n");
		str.append("0 5 5\n");
		str.append("1 5 4\n");
		str.append("1 2 2\n");
		str.append("2 7 15\n");
		str.append("2 3 7\n");
		str.append("3 4 1\n");
		str.append("3 8 20\n");
		str.append("4 11 30\n");
		str.append("5 6 1\n");
		str.append("6 7 2\n");
		str.append("6 9 6\n");
		str.append("7 8 1\n");
		str.append("8 10 5\n");
		str.append("9 10 4\n");
		str.append("10 11 5\n");
		str.append("0 0 0\n");
		
		
		System.out.println("-- Programa para eulerizar um grafo e imprimir o ciclo euleriano --");
		System.out.println("Para este programa foi utilizado o grafo exemplo do trabalho... (conforme grafo.png nesse projeto)");
		System.out.println("");

		Scanner scanner = new Scanner(str.toString());

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
