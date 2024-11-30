package ma.chat.tp5poo.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ma.chat.tp5poo.metier.IMetier;
import ma.chat.tp5poo.metier.MetierImp;
import ma.chat.tp5poo.model.Departement;
import ma.chat.tp5poo.model.Professeur;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class DepartementController implements Initializable {


    private final IMetier metier = new MetierImp();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @FXML
    private TableView<Departement> departementTable;
    @FXML private TableColumn<Departement, Integer> idColumn;
    @FXML private TableColumn<Departement, String> nomColumn;
    @FXML private TableColumn<Departement, Void> actionsColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupTable();
        loadDepartements();
    }

    private void setupTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_deprat"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        setupActionsColumn();
    }

    private void setupActionsColumn() {
        actionsColumn.setCellFactory(param -> new TableCell<>() {
            private final Button editBtn = new Button("Modifier");
            private final Button deleteBtn = new Button("Supprimer");
            private final Button viewProfsBtn = new Button("Professeurs");

            {
                editBtn.setOnAction(event -> handleEdit(getTableView().getItems().get(getIndex())));
                deleteBtn.setOnAction(event -> handleDelete(getTableView().getItems().get(getIndex())));
                viewProfsBtn.setOnAction(event -> handleViewProfesseurs(getTableView().getItems().get(getIndex())));
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox buttons = new HBox(5, editBtn, deleteBtn, viewProfsBtn);
                    setGraphic(buttons);
                }
            }
        });
    }

    private void loadDepartements() {
        departementTable.setItems(FXCollections.observableArrayList(metier.getAllDepartements()));
    }

    @FXML
    private void handleAdd() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Ajout d'un département");
        dialog.setHeaderText("Ajouter un département");
        dialog.setContentText("Nom :");

        dialog.showAndWait().ifPresent(nom -> {
            Departement dept = new Departement();
            dept.setNom(nom);
            metier.addDepartement(dept);
            loadDepartements();
        });
    }

    private void handleEdit(Departement departement) {
        TextInputDialog dialog = new TextInputDialog(departement.getNom());
        dialog.setTitle("Modification");
        dialog.setHeaderText("Modification");
        dialog.setContentText("Choisir un nouveau nom:");

        dialog.showAndWait().ifPresent(nom -> {
            departement.setNom(nom);
            metier.updateDepartement(departement);
            loadDepartements();
        });
    }

    private void handleDelete(Departement departement) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Suppression du departement");
        alert.setContentText("Êtes-vous sûr ?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                metier.removeDepartement(departement.getId_deprat());
                loadDepartements();
            }
        });
    }

    private void handleViewProfesseurs(Departement departement) {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Professeurs de ce departement");
        dialog.setHeaderText(" Professeurs de ce département: " +"\""+ departement.getNom()+"\"");

        TableView<Professeur> professeursTable = new TableView<>();

        TableColumn<Professeur, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id_prof"));

        TableColumn<Professeur, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Professeur, String> prenomCol = new TableColumn<>("Prénom");
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        TableColumn<Professeur, String> cinCol = new TableColumn<>("CIN");
        cinCol.setCellValueFactory(new PropertyValueFactory<>("cin"));

        TableColumn<Professeur, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Professeur, String> dateCol = new TableColumn<>("Date Recrutement");
        dateCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(dateFormat.format(cellData.getValue().getDate_recrutement())));

        professeursTable.getColumns().addAll(
                idCol, nomCol, prenomCol, cinCol, emailCol, dateCol
        );

        professeursTable.setItems(
                FXCollections.observableArrayList(
                        metier.getProfesseursByDepartement(departement.getId_deprat())
                )
        );

        professeursTable.setMinWidth(600);
        professeursTable.setMinHeight(400);

        VBox content = new VBox(10);
        content.getChildren().add(professeursTable);
        dialog.getDialogPane().setContent(content);

        ButtonType closeButton = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(closeButton);
        dialog.showAndWait();
    }
}
