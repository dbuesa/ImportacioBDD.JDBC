package Exercicis.objectes;

public class Candidatura {
    int candidatura_id;
    int eleccio_id;
    String codi_candidatura;
    String nom_curt;
    String nom_llarg;
    String codi_acumulacio_provincia;
    String codi_acumulacio_ca;
    String codi_acumulacio_nacional;

    public Candidatura(int candidatura_id, int eleccio_id, String codi_candidatura, String nom_curt, String nom_llarg, String codi_acumulacio_provincia, String codi_acumulacio_ca, String codi_acumulacio_nacional) {
        this.candidatura_id = candidatura_id;
        this.eleccio_id = eleccio_id;
        this.codi_candidatura = codi_candidatura;
        this.nom_curt = nom_curt;
        this.nom_llarg = nom_llarg;
        this.codi_acumulacio_provincia = codi_acumulacio_provincia;
        this.codi_acumulacio_ca = codi_acumulacio_ca;
        this.codi_acumulacio_nacional = codi_acumulacio_nacional;
    }

    public int getCandidatura_id() {
        return candidatura_id;
    }

    public int getEleccio_id() {
        return eleccio_id;
    }

    public String getCodi_candidatura() {
        return codi_candidatura;
    }

    public String getNom_curt() {
        return nom_curt;
    }

    public String getNom_llarg() {
        return nom_llarg;
    }

    public String getCodi_acumulacio_provincia() {
        return codi_acumulacio_provincia;
    }

    public String getCodi_acumulacio_ca() {
        return codi_acumulacio_ca;
    }

    public String getCodi_acumulacio_nacional() {
        return codi_acumulacio_nacional;
    }

    public void setCandidatura_id(int candidatura_id) {
        this.candidatura_id = candidatura_id;
    }

    public void setEleccio_id(int eleccio_id) {
        this.eleccio_id = eleccio_id;
    }

    public void setCodi_candidatura(String codi_candidatura) {
        this.codi_candidatura = codi_candidatura;
    }

    public void setNom_curt(String nom_curt) {
        this.nom_curt = nom_curt;
    }

    public void setNom_llarg(String nom_llarg) {
        this.nom_llarg = nom_llarg;
    }

    public void setCodi_acumulacio_provincia(String codi_acumulacio_provincia) {
        this.codi_acumulacio_provincia = codi_acumulacio_provincia;
    }

    public void setCodi_acumulacio_ca(String codi_acumulacio_ca) {
        this.codi_acumulacio_ca = codi_acumulacio_ca;
    }

    public void setCodi_acumulacio_nacional(String codi_acumulacio_nacional) {
        this.codi_acumulacio_nacional = codi_acumulacio_nacional;
    }
}
