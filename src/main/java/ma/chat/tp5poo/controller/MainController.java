package ma.chat.tp5poo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private BorderPane mainPane;

    @FXML
    private void home(ActionEvent event) throws IOException {
        loadPage("home");
    }

    @FXML
    private void Professeurs(ActionEvent event) throws IOException {
        loadPage("ProfesseurSection");
    }

    @FXML
    private void Départements(ActionEvent event) throws IOException {
        loadPage("departementSection");
    }

    private void loadPage(String page) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        mainPane.setCenter(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (mainPane == null) {
            System.err.println("mainPane is null!");
        }
    }
}
