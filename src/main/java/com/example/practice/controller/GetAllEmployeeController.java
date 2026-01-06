package com.example.practice.controller;

import com.example.practice.HelloApplication;
import com.example.practice.employeeDto.EmployeeDto;
import com.example.practice.service.EmployeeService;
import com.example.practice.service.impl.EmployeeServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class GetAllEmployeeController {

    @FXML
    private AnchorPane root;
    @FXML
    private TableColumn<EmployeeDto, Integer> tblAge;

    @FXML
    private TableColumn<EmployeeDto, String> tblName;

    @FXML
    private TableColumn<EmployeeDto, String> tblNic;

    @FXML
    private TableColumn<EmployeeDto, Double> tblSalary;

    @FXML
    private TableView<EmployeeDto> tableView;

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
    void getAll(ActionEvent event) {
        List<EmployeeDto> employees = employeeService.getAllEmployees();

        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        tblSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tableView.getItems().setAll(employees);
    }

}
