package de.layla.berufsschule.Auftrag1a;

import java.io.FileWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

/* Auftrag 1a) Erstellen Sie folgende book1a.json:
    {
    	"titel" : "XQuery Kick Start"
    }
*/

public class WriteBookDataJason {

	public static void main(String[] args) {

		Buch buch = new Buch("XQuery Kick Start");

		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("titel", buch.getTitel());

		JsonObject jo = builder.build();

		try {
			FileWriter fw = new FileWriter("book1a.json");
			JsonWriter jw = Json.createWriter(fw);
			jw.write(jo);
			fw.close();
			jw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
