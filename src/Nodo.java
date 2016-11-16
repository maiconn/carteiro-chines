import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nodo {
	private Integer nome;
	private List<Nodo> filhos;
	private Map<Nodo, Integer> valores;
	
	public Nodo(Integer nome) {
		this.nome = nome;
		this.filhos = new ArrayList<Nodo>();
		this.valores = new HashMap<>();
	}

	public void adicionarFilho(Nodo nodo, int valor) {
		this.filhos.add(nodo);
		this.valores.put(nodo, valor);
	}
	
	public int getValorAresta(Nodo nodo){
		return this.valores.get(nodo);
	}

	public int quantidadeDeFilhos() {
		return filhos.size();
	}

	public List<Nodo> getFilhos() {
		return filhos;
	}
	
	public Integer getNome() {
		return nome;
	}

}
