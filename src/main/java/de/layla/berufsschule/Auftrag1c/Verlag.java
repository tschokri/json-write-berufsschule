package de.layla.berufsschule.Auftrag1c;

public class Verlag {

	String name;
	String ort;

	public Verlag(String name, String ort) {
		super();
		this.name = name;
		this.ort = ort;
	}

	public String getName() {
		return name;
	}

	public String getOrt() {
		return ort;
	}

	@Override
	public String toString() {
		return "Verlag [name=" + name + ", ort=" + ort + "]";
	}

}
