package de.layla.berufsschule.Auftrag1b;

import java.util.ArrayList;

public class Buch {
	private String titel;
	private ArrayList<String> autorenliste;

	public Buch(String titel, ArrayList<String> autorenliste) {
		this.titel = titel;
		this.autorenliste = autorenliste;
	}

	public String getTitel() {
		return titel;
	}
	
	public ArrayList<String> getAutorenliste() {
		return autorenliste;
	}
	
}
