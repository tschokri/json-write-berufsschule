package de.layla.berufsschule.Auftrag5;

import java.util.ArrayList;

public class Buchhandlung {
    private String name;
    private String tel;
    private String fax;
    private Adresse adresse;
    private ArrayList<Buch> buchliste;
    

    public Buchhandlung(String name, String tel, String fax, Adresse adresse, ArrayList<Buch> buchliste) {
        this.name = name;
        this.tel = tel;
        this.fax = fax;
        this.adresse = adresse;
        this.buchliste = buchliste;
    }

    public Buchhandlung() {
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getFax() {
        return fax;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public ArrayList<Buch> getBuchliste() {
        return buchliste;
    }
}
