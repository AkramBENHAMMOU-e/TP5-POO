package ma.chat.tp5poo.model;

import javafx.beans.binding.BooleanExpression;

import java.util.Date;

public class Professeur {
    private int id_prof;
    private String nom;
    private String prenom;
    private String cin;
    private String adresse;
    private String telephone;
    private String email;
    private Date date_recrutement;
    private int departement_id;

    public Professeur(int id_prof, String nom, String prenom, String cin, String adresse, String telephone, String email, Date date_recrutement, int departement_id) {
        this.id_prof = id_prof;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.date_recrutement = date_recrutement;
        this.departement_id = departement_id;
    }

    public Professeur() {
    }

    public Professeur(String nom, String prenom, String cin, String adresse, String telephone, String email, Date date_recrutement, int departement_id) {
        this(0, nom, prenom, cin, adresse, telephone, email, date_recrutement, departement_id);    }

    public int getId_prof() {
        return id_prof;
    }

    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    public int getDepartement_id() {
        return departement_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_recrutement() {
        return date_recrutement;
    }

    public void setDate_recrutement(Date date_recrutement) {
        this.date_recrutement = date_recrutement;
    }

    public int getDepartement() {
        return departement_id;
    }

    public void setDepartement(int departement_id) {
        this.departement_id = departement_id;
    }

}
