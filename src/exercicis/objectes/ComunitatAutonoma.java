package exercicis.objectes;

public class ComunitatAutonoma {
    long comunitat_aut_id;
    String nom;
    String codi_ine;

    public ComunitatAutonoma(String nom, String codi_ine) {
        this.nom = nom;
        this.codi_ine = codi_ine;
    }

    public ComunitatAutonoma(String nom) {
        this.nom = nom;
    }

    public ComunitatAutonoma() {

    }

    public long getComunitat_aut_id() {
        return comunitat_aut_id;
    }

    public String getNom() {
        return nom;
    }

    public String getCodi_ine() {
        return codi_ine;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setComunitat_aut_id(long comunitat_aut_id) {
        this.comunitat_aut_id = comunitat_aut_id;
    }

    public void setCodi_ine(String codi_ine) {
        this.codi_ine = codi_ine;
    }


    @Override
    public String toString() {
        return "ComunitatAutonoma{" +
                ", nom='" + nom + '\'' +
                ", codi_ine='" + codi_ine + '\'' +
                '}';
    }
}
