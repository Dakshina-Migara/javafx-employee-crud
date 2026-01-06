package com.example.practice.controller;

import com.example.practice.employeeDto.EmployeeDto;
import com.example.practice.service.EmployeeService;
import com.example.practice.service.impl.EmployeeServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class GetAllEmployeeController {

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
    void back(ActionEvent event) {

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
