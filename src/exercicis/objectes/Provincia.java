package exercicis.objectes;

public class Provincia{
    int provincia_id;
    int comunitat_aut_id;
    String nom;
    String codi_ine;
    int num_escons;


    public Provincia(int provincia_id, int comunitat_aut_id, String nom, String codi_ine, int num_escons) {
        this.provincia_id = provincia_id;
        this.comunitat_aut_id = comunitat_aut_id;
        this.nom = nom;
        this.codi_ine = codi_ine;
        this.num_escons = num_escons;
    }

    public int getProvincia_id() {
        return provincia_id;
    }

    public int getComunitat_aut_id() {
        return comunitat_aut_id;
    }

    public String getNom() {
        return nom;
    }

    public String getCodi_ine() {
        return codi_ine;
    }

    public int getNum_escons() {
        return num_escons;
    }

    public void setProvincia_id(int provincia_id) {
        this.provincia_id = provincia_id;
    }

    public void setComunitat_aut_id(int comunitat_aut_id) {
        this.comunitat_aut_id = comunitat_aut_id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCodi_ine(String codi_ine) {
        this.codi_ine = codi_ine;
    }

    public void setNum_escons(int num_escons) {
        this.num_escons = num_escons;
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "provincia_id=" + provincia_id +
                ", comunitat_aut_id=" + comunitat_aut_id +
                ", nom='" + nom + '\'' +
                ", codi_ine='" + codi_ine + '\'' +
                ", num_escons=" + num_escons +
                '}';
    }
}
