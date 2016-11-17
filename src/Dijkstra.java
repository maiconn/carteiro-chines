import java.util.LinkedList;

public class Dijkstra {
	private static final int NIL = -1;
	private static final int INFINITY = Integer.MAX_VALUE;
	private Grafo grafo;
	private int[] dist;
	private int[] pai;

	public Dijkstra(Grafo grafo, int origem) {
		this.grafo = grafo;
		this.executarAlgoritmo(origem);
	}

	private void executarAlgoritmo(int origem){
		LinkedList<Nodo> Q = new LinkedList<Nodo>();
		
		dist = new int[grafo.getQtdNodos()];
		pai = new int[grafo.getQtdNodos()];
		for(int i = 0; i < grafo.getQtdNodos() ; i++){
			dist[i] = INFINITY;
			pai[i] = NIL;
			Q.push(grafo.getNodo(i));
		}
		
		dist[origem] = 0;
		
		while(!Q.isEmpty()){
			Nodo u = removeMenor(Q);
			
			for(Nodo v : u.getFilhos()){
				int alt = dist[u.getNome()] + u.getValorAresta(v);
				if(alt < dist[v.getNome()]){
					dist[v.getNome()] = alt;
					pai[v.getNome()] = u.getNome();
				}
			}
		}
	}
	
	private Nodo removeMenor(LinkedList<Nodo> Q) {
		int menor = INFINITY;
		Nodo menorNodo = null;
		for (Nodo nodo : Q) {
			if (dist[nodo.getNome()] < menor) {
				menor = dist[nodo.getNome()];
				menorNodo = nodo;
			}
		}
		Q.remove(menorNodo);

		return menorNodo;
	}
	
	public int[] dist() {
		return dist;
	}
	
	public LinkedList<Integer> retornaCaminho(int u, int v) throws Exception{
		LinkedList<Integer> caminho = new LinkedList<>();
		
		int localV = v;
		while(pai[localV] != u){
			if(pai[localV] == NIL){
				throw new Exception("Não existe esse caminho... ["+u+" -> "+v+"]");
			}
			caminho.addFirst(pai[localV]);
			localV = pai[localV];
		}
		caminho.addFirst(u);
		caminho.addLast(v);
		return caminho;
	}
}
