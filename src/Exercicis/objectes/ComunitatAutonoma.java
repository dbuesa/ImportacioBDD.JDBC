package Exercicis.objectes;

import Exercicis.objectes.DAO.DAODB;

public class ComunitatAutonoma {
    String nom;
    String codi_ine;

    public ComunitatAutonoma(String nom, String codi_ine) {
        this.nom = nom;
        this.codi_ine = codi_ine;
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
