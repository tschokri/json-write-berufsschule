package de.layla.berufsschule.Auftrag1c;

import java.util.ArrayList;

public class Buch {
	private String titel;
	private ArrayList<String> autorenliste;
	private Verlag verlag;

	public Buch(String titel, ArrayList<String> autorenliste, Verlag verlag) {
		this.titel = titel;
		this.autorenliste = autorenliste;
		this.verlag = verlag;
	}

	public String getTitel() {
		return titel;
	}

	public ArrayList<String> getAutorenliste() {
		return autorenliste;
	}

	public Verlag getVerlag() {
		return verlag;
	}

	@Override
	public String toString() {
		return "Buch [titel=" + titel + ", autorenliste=" + autorenliste + ", verlag=" + verlag + "]";
	}

}
