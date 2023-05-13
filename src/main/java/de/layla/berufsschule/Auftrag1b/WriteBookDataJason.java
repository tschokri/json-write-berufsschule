package de.layla.berufsschule.Auftrag1b;

/* Auftrag 1b) Erstellen Sie folgende book1b.json:
{
	"titel": "XQuery Kick Start",
	"autoren": [
		"James McGovern",
		"Per Bothner",
		"Kurt Cagle",
		"James Linn"
	]
}
*/

import java.io.FileWriter;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

public class WriteBookDataJason {

	public static void main(String[] args) {

		ArrayList<String> autorenliste = new ArrayList<String>();
		autorenliste.add("James McGovern");
		autorenliste.add("Per Bothner");
		autorenliste.add("Kurt Cagle");
		autorenliste.add("James Linn");
		Buch buch = new Buch("XQuery Kick Start", autorenliste);

		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("titel", buch.getTitel());

		JsonArrayBuilder autorArray = Json.createArrayBuilder();
		for (String autor : buch.getAutorenliste()) {
			autorArray.add(autor);
		}
		builder.add("autoren", autorArray);

		JsonObject jo = builder.build();

		try {
			FileWriter fw = new FileWriter("book1b.json");
			JsonWriter jw = Json.createWriter(fw);
			jw.write(jo);
			fw.close();
			jw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
