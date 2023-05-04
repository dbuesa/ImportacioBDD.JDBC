package Exercicis.objectes;

import Exercicis.objectes.DAO.DAODB;

public class Candidat {
    int candidat_id;
    int candidatura_id;
    int persona_id;
    int provincia_id;
    int num_ordre;
    char tipus;

    public Candidat(int candidat_id, int candidatura_id, int persona_id, int provincia_id, int num_ordre, char tipus) {
        this.candidat_id = candidat_id;
        this.candidatura_id = candidatura_id;
        this.persona_id = persona_id;
        this.provincia_id = provincia_id;
        this.num_ordre = num_ordre;
        this.tipus = tipus;
    }

    public int getCandidat_id() {
        return candidat_id;
    }

    public int getCandidatura_id() {
        return candidatura_id;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public int getProvincia_id() {
        return provincia_id;
    }

    public int getNum_ordre() {
        return num_ordre;
    }

    public char getTipus() {
        return tipus;
    }

    public void setCandidat_id(int candidat_id) {
        this.candidat_id = candidat_id;
    }

    public void setCandidatura_id(int candidatura_id) {
        this.candidatura_id = candidatura_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public void setProvincia_id(int provincia_id) {
        this.provincia_id = provincia_id;
    }

    public void setNum_ordre(int num_ordre) {
        this.num_ordre = num_ordre;
    }

    public void setTipus(char tipus) {
        this.tipus = tipus;
    }

    @Override
    public String toString() {
        return "Candidat{" +
                "candidat_id=" + candidat_id +
                ", candidatura_id=" + candidatura_id +
                ", persona_id=" + persona_id +
                ", provincia_id=" + provincia_id +
                ", num_ordre=" + num_ordre +
                ", tipus=" + tipus +
                '}';
    }
}
