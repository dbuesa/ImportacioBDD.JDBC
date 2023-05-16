package exercicis.objectes;

public class Municipi{
    int municipi_id;
    String nom;
    String codi_ine;
    int provincia_id;
    String districte;

    public Municipi(int municipi_id, String nom, String codi_ine, int provincia_id, String districte) {
        this.municipi_id = municipi_id;
        this.nom = nom;
        this.codi_ine = codi_ine;
        this.provincia_id = provincia_id;
        this.districte = districte;
    }

    public int getMunicipi_id() {
        return municipi_id;
    }

    public String getNom() {
        return nom;
    }

    public String getCodi_ine() {
        return codi_ine;
    }

    public int getProvincia_id() {
        return provincia_id;
    }

    public String getDistricte() {
        return districte;
    }

    public void setMunicipi_id(int municipi_id) {
        this.municipi_id = municipi_id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCodi_ine(String codi_ine) {
        this.codi_ine = codi_ine;
    }

    public void setProvincia_id(int provincia_id) {
        this.provincia_id = provincia_id;
    }

    public void setDistricte(String districte) {
        this.districte = districte;
    }


    @Override
    public String toString() {
        return "Municipi{" +
                "municipi_id=" + municipi_id +
                ", nom='" + nom + '\'' +
                ", codi_ine='" + codi_ine + '\'' +
                ", provincia_id=" + provincia_id +
                ", districte='" + districte + '\'' +
                '}';
    }
}
