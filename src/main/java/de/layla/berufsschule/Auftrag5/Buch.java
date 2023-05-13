package de.layla.berufsschule.Auftrag5;
import java.util.*;

public class Buch {
	private String titel;
	private int jahr;
	private double preis;
	private ArrayList<String> autorenliste;

	public Buch(String titel, int jahr, double preis, ArrayList<String> autorenliste) {
		this.titel = titel;
		this.jahr = jahr;
		this.preis = preis;
		this.autorenliste = autorenliste;
	}

	public String getTitel() {
		return titel;
	}

	public int getJahr() {
		return jahr;
	}


	public double getPreis() {
		return preis;
	}	

	public ArrayList<String> getAutorenliste() {
		return autorenliste;
	}
	
}
