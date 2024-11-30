package ma.chat.tp5poo.metier;

import ma.chat.tp5poo.dao.SingletonConnexionDB;
import ma.chat.tp5poo.model.Departement;
import ma.chat.tp5poo.model.Professeur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierImp implements IMetier {
private final Connection connection = SingletonConnexionDB.getConnection();
    @Override
    public void addProfesseur(Professeur prof) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO professeur(id_prof,nom, prenom, cin, adresse, telephone, email, date_recrutement , departement_id) Values (?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, prof.getId_prof());
            ps.setString(2, prof.getNom());
            ps.setString(3, prof.getPrenom());
            ps.setString(4, prof.getCin());
            ps.setString(5, prof.getAdresse());
            ps.setString(6, prof.getTelephone());
            ps.setString(7, prof.getEmail());
            ps.setDate(8,new java.sql.Date(prof.getDate_recrutement().getTime()));
            ps.setInt(9, prof.getDepartement_id());
            ps.executeUpdate();
            System.out.println("Prof ajouté");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
    }

    @Override
    public void deleteProfesseur(int id_prof) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM professeur where id_prof=?");
            ps.setInt(1,id_prof);
            ps.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateProfesseur(Professeur prof) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE professeurs SET nom=?, prenom=?, cin=?, adresse=?, telephone=?, email=?, " +
                            "date_recrutement=? , departement_id=? WHERE id_prof=?"
            );
            ps.setString(1, prof.getNom());
            ps.setString(2, prof.getPrenom());
            ps.setString(3, prof.getCin());
            ps.setString(4, prof.getAdresse());
            ps.setString(5, prof.getTelephone());
            ps.setString(6, prof.getEmail());
            ps.setDate(7, new java.sql.Date(prof.getDate_recrutement().getTime()));
            ps.setInt(8, prof.getDepartement_id());
            ps.setInt(9, prof.getId_prof());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Professeur> getAllProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * From professeur");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               Professeur p = new Professeur();
               p.setId_prof(rs.getInt("id_prof"));
               p.setNom(rs.getString("nom"));
               p.setPrenom(rs.getString("prenom"));
               p.setCin(rs.getString("cin"));
               p.setAdresse(rs.getString("adresse"));
               p.setTelephone(rs.getString("telephone"));
               p.setEmail(rs.getString("email"));
               p.setDate_recrutement(rs.getDate("date_recrutement"));
               p.setDepartement(rs.getInt("departement_id"));
               professeurs.add(p);
            }
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        return professeurs;
    }

    @Override
    public List<Professeur> searchProfesseurs(String keyword) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM professeur p LEFT JOIN departement d ON p.departement_id = d.id_depart WHERE p.nom LIKE ? OR p.prenom LIKE ? OR p.cin LIKE ?");
            String key = "%" + keyword + "%";
            ps.setString(1, key);
            ps.setString(2, key);
            ps.setString(3, key);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Professeur p = new Professeur();
                p.setId_prof(rs.getInt("id_prof"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setCin(rs.getString("cin"));
                p.setAdresse(rs.getString("adresse"));
                p.setTelephone(rs.getString("telephone"));
                p.setEmail(rs.getString("email"));
                p.setDate_recrutement(rs.getDate("date_recrutement"));
                professeurs.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return professeurs;
    }

    @Override
    public void addDepartement(Departement dept) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO departement(id_depart,nom) VALUES(?,?)");
            ps.setInt(1,dept.getId_deprat());
            ps.setString(2, dept.getNom());
            ps.executeUpdate();
            System.out.println("Departement ajouté à BD");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeDepartement(int id_depart) {
        try{
            PreparedStatement ps = connection.prepareStatement("DELETE From departement WHERE id_depart=?");
            ps.setInt(1,id_depart);
            ps.executeUpdate();
            System.out.println("dep supprimé");

        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateDepartement(Departement dept) {
        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE departement SET nom=? WHERE id_depart=?");
            ps.setString(1,dept.getNom());
            ps.setInt(2,dept.getId_deprat());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    @Override
    public List<Departement> getAllDepartements() {
        List<Departement> departements = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("Select id_depart,nom from departement");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Departement d = new Departement();
                d.setId_deprat(rs.getInt("id_depart"));
                d.setNom(rs.getString("nom"));
                System.out.println(d.getId_deprat());
                departements.add(d);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return departements;
    }


    @Override
    public List<Professeur> getProfesseursByDepartement(int id_deprat) {
        List<Professeur> professeurs = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * From professeur WHERE departement_id=?");
            ps.setInt(1,id_deprat);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Professeur p = new Professeur();
                p.setId_prof(rs.getInt("id_prof"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setCin(rs.getString("cin"));
                p.setAdresse(rs.getString("adresse"));
                p.setTelephone(rs.getString("telephone"));
                p.setEmail(rs.getString("email"));
                p.setDate_recrutement(rs.getDate("date_recrutement"));
                professeurs.add(p);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return professeurs;
    }
}
