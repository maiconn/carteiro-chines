import java.util.ArrayList;
import java.util.List;

public class Nodo {
	private Integer nome;
	private List<Nodo> filhos;
	
	public Nodo(Integer nome) {
		this.nome = nome;
		this.filhos = new ArrayList<Nodo>();
	}

	public void adicionarFilho(Nodo nodo, int valor) {
		if(!filhos.contains(nodo)){			
			this.filhos.add(nodo);
		}
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
	
	@Override
	public String toString() {
		return this.getNome().toString();
	}

}
