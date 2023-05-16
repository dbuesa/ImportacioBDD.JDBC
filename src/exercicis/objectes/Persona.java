package exercicis.objectes;

public class Persona{
    long persona_id;
    String nom;
    String cog1;
    String cog2;
    String dni;


    public Persona(String nom, String cog1, String cog2, String dni) {
        this.nom = nom;
        this.cog1 = cog1;
        this.cog2 = cog2;
        this.dni = dni;
    }

    public Persona(String nom) {
        this.nom = nom;
    }



    public Persona() {
        this.persona_id = persona_id;
    }

    public void setPersona_id(long persona_id) {
        this.persona_id = persona_id;
    }

    public long getPersona_id() {
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
                ", dni='" + dni + '\'' +
                '}';
    }
}
