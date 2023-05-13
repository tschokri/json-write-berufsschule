package de.layla.berufsschule.Auftrag4;

public class Buch {
	private String titel;
	private int jahr;
	private double preis;
	private String autor;

	public Buch(String titel, int jahr, double preis, String autor) {
		this.titel = titel;
		this.jahr = jahr;
		this.preis = preis;
		this.autor = autor;
	}

	public String getTitel() {
		return titel;
	}

	public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
}
