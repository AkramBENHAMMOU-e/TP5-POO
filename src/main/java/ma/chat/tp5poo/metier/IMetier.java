package ma.chat.tp5poo.metier;

import ma.chat.tp5poo.model.Departement;
import ma.chat.tp5poo.model.Professeur;

import java.util.List;

public interface IMetier {
    void addProfesseur(Professeur prof);
    void deleteProfesseur(int id_prof);
    void updateProfesseur(Professeur prof);
    List<Professeur> getAllProfesseurs();
    List<Professeur> searchProfesseurs(String keyword);

    void addDepartement(Departement dept);
    void removeDepartement(int id_deprat);
    void updateDepartement(Departement dept);
    List<Departement> getAllDepartements();
    List<Professeur> getProfesseursByDepartement(int id_deprat);


}
