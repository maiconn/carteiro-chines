import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Grafo {
	private Map<Integer, Nodo> nodos;
	private int qtdNodos;

	public Grafo(int qtdNodos) {
		this.nodos = new HashMap<Integer, Nodo>();
		this.qtdNodos = qtdNodos;
		for (int i = 0; i < qtdNodos; i++) {
			adicionarNodo(new Nodo(i));
		}
	}

	public int getQtdNodos() {
		return qtdNodos;
	}

	public Nodo getNodo(int nodo) {
		return this.nodos.get(nodo);
	}

	public Nodo adicionarNodo(Nodo nodo) {
		nodos.put(nodo.getNome(), nodo);
		return nodos.get(nodo.getNome());
	}

	public void criarAresta(Integer nodoOrigem, Integer nodoDestino, Integer valor) {
		Nodo origem = nodos.get(nodoOrigem);
		Nodo destino = nodos.get(nodoDestino);

		origem.adicionarFilho(destino, valor);
		destino.adicionarFilho(origem, valor);
	}

	public void carteiroChines() throws Exception {
		List<Nodo> impares = getImpares();
		Map<Nodo, Dijkstra> dijkstras = new HashMap<>();

		for (Nodo nodo : impares) {
			dijkstras.put(nodo, new Dijkstra(this, nodo.getNome()));
		}
		
		while (!dijkstras.isEmpty()) {
			int menor = Integer.MAX_VALUE;
			Nodo pai = null;
			Nodo filh = null;
			for (Nodo nodo : dijkstras.keySet()) {
				for (Nodo filho : dijkstras.keySet()) {
					if (nodo.getNome() != filho.getNome()) {
						Dijkstra dijkstra = dijkstras.get(filho);
						int val = dijkstra.dist()[nodo.getNome()];
						if (val < menor) {
							menor = val;
							pai = nodo;
							filh = filho;
						}
					}
				}
			}

			// eulerizar criando arestas artificiais...
			LinkedList<Integer> caminho = dijkstras.get(pai).retornaCaminho(pai.getNome(), filh.getNome());
			int u = caminho.removeFirst();
			int v = caminho.removeFirst();
			this.criarAresta(u, v, this.getNodo(u).getValorAresta(this.getNodo(v)));
			while (!caminho.isEmpty()) {
				u = v;
				v = caminho.removeFirst();
				this.criarAresta(u, v, this.getNodo(u).getValorAresta(this.getNodo(v)));
			}

			dijkstras.remove(pai);
			dijkstras.remove(filh);
		}
	}

	public List<Nodo> getImpares() {
		List<Nodo> impares = new ArrayList<>();
		for (Nodo nodo : this.nodos.values()) {
			if (nodo.quantidadeDeFilhos() % 2 != 0) {
				impares.add(nodo);
			}
		}

		return impares;
	}

	public void djikstra(int nodoInicial) {

	}
}
