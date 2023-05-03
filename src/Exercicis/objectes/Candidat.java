package Exercicis.objectes;

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
}
