
public class Aresta {
	private Nodo u, v;
	private Integer valor;

	public Aresta(Nodo u, Nodo v, Integer valor) {
		this.u = u;
		this.v = v;
		this.valor = valor;
	}

	public Nodo getU() {
		return u;
	}

	public Nodo getV() {
		return v;
	}

	public Integer getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return "["+u+" -> "+v+" = "+valor+"]";
	}

}
