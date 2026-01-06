package com.example.practice.controller;

import com.example.practice.HelloApplication;
import com.example.practice.service.EmployeeService;
import com.example.practice.service.impl.EmployeeServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteEmployeeController {
    @FXML
    private AnchorPane root;
    @FXML
    private TextField txtNic;

    EmployeeService employeeService = new EmployeeServiceImpl();

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.root.getScene().getWindow();

        //yanna ona scene eka dagannawa
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setScene(scene);
    }

    @FXML
    void delete(ActionEvent event) {
        String nicToDelete = txtNic.getText();
        boolean deleted = employeeService.deleteEmployee(nicToDelete);

        if (deleted) {
            System.out.println("Success, Employee deleted successfully!");

        } else {
            System.out.println("Error, No employee found with this NIC!");
        }
    }
}
