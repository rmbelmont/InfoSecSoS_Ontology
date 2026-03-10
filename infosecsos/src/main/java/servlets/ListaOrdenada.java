package servlets;

import java.util.List;

public class ListaOrdenada {

	String nome;

	public ListaOrdenada(String nome) {

		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "+ nome + ";
	}
}
