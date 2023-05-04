package Exercicis.objectes;

public class Persona implements CRUD{
    int persona_id;
    String nom;
    String cog1;
    String cog2;
    char sexe;
    String data_naixament;
    String dni;


    public Persona(int persona_id, String nom, String cog1, String cog2, char sexe, String data_naixament, String dni) {
        this.persona_id = persona_id;
        this.nom = nom;
        this.cog1 = cog1;
        this.cog2 = cog2;
        this.sexe = sexe;
        this.data_naixament = data_naixament;
        this.dni = dni;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public String getNom() {
        return nom;
    }

    public String getCog1() {
        return cog1;
    }

    public String getCog2() {
        return cog2;
    }

    public char getSexe() {
        return sexe;
    }

    public String getData_naixament() {
        return data_naixament;
    }

    public String getDni() {
        return dni;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCog1(String cog1) {
        this.cog1 = cog1;
    }

    public void setCog2(String cog2) {
        this.cog2 = cog2;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public void setData_naixament(String data_naixament) {
        this.data_naixament = data_naixament;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "persona_id=" + persona_id +
                ", nom='" + nom + '\'' +
                ", cog1='" + cog1 + '\'' +
                ", cog2='" + cog2 + '\'' +
                ", sexe=" + sexe +
                ", data_naixament='" + data_naixament + '\'' +
                ", dni='" + dni + '\'' +
                '}';
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
