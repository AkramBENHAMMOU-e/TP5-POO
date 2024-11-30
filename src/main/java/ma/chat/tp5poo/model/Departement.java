package ma.chat.tp5poo.model;

public class Departement {

    private int id_deprat;
    private String nom;

    public Departement(int i, String nom) {
        this.id_deprat=i;
        this.nom=nom;
    }

    public Departement() {
    }

    public int getId_deprat() {
        return id_deprat;
    }

    public void setId_deprat(int idDept) {
        this.id_deprat = idDept;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
