package com.example.practice.controller;

import com.example.practice.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {
    @FXML
    private AnchorPane root;

    @FXML
    void toDelete(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root.getScene().getWindow();

        //yanna ona scene eka dagannawa
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("delete-employee.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setScene(scene);
    }

    @FXML
    void toGetAll(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root.getScene().getWindow();

        //yanna ona scene eka dagannawa
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("get-all.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setScene(scene);
    }

    @FXML
    void toSaveEmployee(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root.getScene().getWindow();

        //yanna ona scene eka dagannawa
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("save-employee.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setScene(scene);
    }

    @FXML
    void toUpdateEmployee(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root.getScene().getWindow();

        //yanna ona scene eka dagannawa
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("update-employee.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setScene(scene);
    }
}
