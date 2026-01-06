package com.example.practice.controller;

import com.example.practice.service.EmployeeService;
import com.example.practice.service.impl.EmployeeServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DeleteEmployeeController {
    @FXML
    private TextField txtNic;

    EmployeeService employeeService = new EmployeeServiceImpl();

    @FXML
    void back(ActionEvent event) {

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
