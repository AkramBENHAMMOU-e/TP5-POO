package ma.chat.tp5poo;

import ma.chat.tp5poo.metier.IMetier;
import ma.chat.tp5poo.metier.MetierImp;
import ma.chat.tp5poo.model.Departement;
import ma.chat.tp5poo.model.Professeur;

import java.util.Date;
import java.util.List;

public class TestConsole {

    public static void main(String[] args){
        IMetier m = new MetierImp();
        Departement dept1 = new Departement(1, "Informatique");
        Departement dept2 = new Departement(2, "Mathématiques");
        Departement dept3 = new Departement(3, "Physique");
        Professeur prof1 = new Professeur(1, "Dupont", "Jean", "C123456", "123 Rue A", "0600000001", "jean.dupont@example.com", new Date(), 1);
        Professeur prof2 = new Professeur(2, "Martin", "Claire", "C234567", "234 Rue B", "0600000002", "claire.martin@example.com", new Date(), 2);
        Professeur prof3 = new Professeur(3, "Bernard", "Louis", "C345678", "345 Rue C", "0600000003", "louis.bernard@example.com", new Date(), 3);
        Professeur prof4 = new Professeur(4, "Petit", "Marie", "C456789", "456 Rue D", "0600000004", "marie.petit@example.com", new Date(), 2);
        Professeur prof5 = new Professeur(5, "Robert", "Paul", "C567890", "567 Rue E", "0600000005", "paul.robert@example.com", new Date(), 2);
        Professeur prof6 = new Professeur(6, "Richard", "Sophie", "C678901", "678 Rue F", "0600000006", "sophie.richard@example.com", new Date(), 1);
        Professeur prof7 = new Professeur(7, "Durand", "Luc", "C789012", "789 Rue G", "0600000007", "luc.durand@example.com", new Date(), 3);
        Professeur prof8 = new Professeur(8, "Leroy", "Julie", "C890123", "890 Rue H", "0600000008", "julie.leroy@example.com", new Date(), 1);
        Professeur prof9 = new Professeur(9, "Moreau", "Pierre", "C901234", "901 Rue I", "0600000009", "pierre.moreau@example.com", new Date(), 3);
        Professeur prof10 = new Professeur(10, "Simon", "Laura", "C012345", "012 Rue J", "0600000010", "laura.simon@example.com", new Date(), 2);
        m.addDepartement(dept1);
        m.addDepartement(dept2);
       m.addProfesseur(prof1);
        m.addProfesseur(prof2);
        m.addProfesseur(prof3);
        m.addProfesseur(prof4);
        m.addProfesseur(prof5);
        m.addProfesseur(prof6);
        m.addProfesseur(prof7);
        m.addProfesseur(prof8);
        m.addProfesseur(prof9);
        m.addProfesseur(prof10);

        List<Professeur> professeurs = m.getProfesseursByDepartement(1);
        for(Professeur p : professeurs){
            System.out.println(p.getNom());
        }

        m.deleteProfesseur(6);

        m.getAllDepartements();
        m.getAllProfesseurs();


    }
}
