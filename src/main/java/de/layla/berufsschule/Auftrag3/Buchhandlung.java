package de.layla.berufsschule.Auftrag3;

public class Buchhandlung {
    private String name;
    private String tel;
    private String fax;
    private Adresse adresse;

    public Buchhandlung(String name, String tel, String fax, Adresse adresse) {
        this.name = name;
        this.tel = tel;
        this.fax = fax;
        this.adresse = adresse;
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
}
