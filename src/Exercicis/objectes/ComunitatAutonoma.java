package Exercicis.objectes;

public class ComunitatAutonoma implements CRUD {
    int comunitat_aut_id;
    String nom;
    String codi_ine;

    public ComunitatAutonoma(int comunitat_aut_id, String nom, String codi_ine) {
        this.comunitat_aut_id = comunitat_aut_id;
        this.nom = nom;
        this.codi_ine = codi_ine;
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

    public void setComunitat_aut_id(int comunitat_aut_id) {
        this.comunitat_aut_id = comunitat_aut_id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCodi_ine(String codi_ine) {
        this.codi_ine = codi_ine;
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public boolean read() {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }
}
