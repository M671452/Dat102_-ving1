package øving2_Oppg1og2;

import java.util.ArrayList;
import java.util.List;

public class Filmarkiv2 implements FilmarkivADT {
	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2() {
		antall = 0;
		start = null;
		
	}

	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> current = start;
		while(current != null) {
			if(current.data.getFilmnr()==nr) {
				return current.data;
			}
			current = current.neste;
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> newNode = new LinearNode<>(nyFilm);
		newNode.neste = start;
		start = newNode;
		antall++;
		
	}

	@Override
	public boolean slettFilm(int filmnr) {
		if(start == null) {
			return false;
		}
		
		if(start.data.getFilmnr()==filmnr) {
			start = start.nest;
			antall--;
			return true;
		}
		
		LinearNode<Film> current = start;
		while(current.nest != null && current.neste.data.getFilmnr()!= filmnr) {
			current = current.neste;
		}
		
		if(current.neste != null) {
			current.neste = current.neste.neste;
			antall--;
			return true;
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		List<Film> result = new ArrayList<>();
		LinearNode<Film> current = start;
		
		while(current != null) {
			if(current.data.getTittel().contains(delstreng)) {
				result.add(current.data);
			}
			current = current.neste;
		}
		return result.toArray(new Film[0]);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		List<Film> result = new ArrayList<>();
		LinearNode<Film> current = start;
		
		while(current != null) {
			if(current.data.getProdusent().contains(delstreng)) {
				result.add(current.data);
			}
			current = current.neste;
		}
		return result.toArray(new Film[0]);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int count = 0;
		LinearNode<Film> current = start;
		
		while(current != null) {
			if(current.data.getSjanger() == sjanger) {
				count++;
			}
			current = current.neste;
		}
		return count;
	}

	@Override
	public int antall() {
		return antall;
	}
	
	private static class LinearNode<T>{
		public T data;
		public LinearNode<T> neste;
		
		public LinearNode(T data) {
			this.data=data;
			this.neste=null;
		}
	}
	

}
