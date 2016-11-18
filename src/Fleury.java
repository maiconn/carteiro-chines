import java.util.LinkedList;
import java.util.List;

public class Fleury {
	private Grafo grafo;

	public Fleury(Grafo grafo) {
		this.grafo = grafo;
		executarAlgoritmo();
	}

	private void executarAlgoritmo() {
		Nodo v0 = grafo.getNodo(0);
		LinkedList<Nodo> C = new LinkedList<Nodo>();
		C.add(v0);
		while (!grafo.getArestas().isEmpty()) {
			Nodo vi = C.getLast();
			Aresta ai = null;
			List<Aresta> incidencias = grafo.incidencias(vi);
			if (incidencias.size() == 1) {
				ai = incidencias.get(0);
			} else {
				ai = getArestaQueNaoEhPonte(incidencias, vi);
			}

			Nodo vj = null;
			if (ai.getU().getNome() == vi.getNome()) {
				vj = ai.getV();
			} else {
				vj = ai.getU();
			}

			grafo.getArestas().remove(ai);
			C.addLast(vj);
		}

		System.out.println(C);
	}

	private Aresta getArestaQueNaoEhPonte(List<Aresta> arestas, Nodo u) {
		for (Aresta a : arestas) {
			Nodo v = null;
			if (a.getU().getNome() == u.getNome()) {
				v = a.getV();
			} else {
				v = a.getU();
			}

			if (grafo.incidencias(v).size() > 1) {
				return a;
			}
		}
		return null;
	}
}
