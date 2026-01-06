package com.example.practice.controller;

import com.example.practice.HelloApplication;
import com.example.practice.employeeDto.EmployeeDto;
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

public class UpdateEmployeeController {

    @FXML
    private AnchorPane root;
    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtSnic;

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
    void search(ActionEvent event) {
        String nic = txtSnic.getText().trim();

        if (nic.isEmpty()) {
            System.out.println("Error, Please enter a NIC to search");
            return;
        }

        EmployeeDto employee = employeeService.getEmployeeByNic(nic);

        if (employee != null) {
            txtName.setText(employee.getName());
            txtNic.setText(employee.getNic()); // keep non-editable
            txtAge.setText(String.valueOf(employee.getAge()));
            txtSalary.setText(String.valueOf(employee.getSalary()));
        } else {
            System.out.println("Not Found, No employee with this NIC");
        }
    }

    @FXML
    void update(ActionEvent event) {
        try {
            EmployeeDto employeeDto = new EmployeeDto(
                    txtName.getText(),
                    txtNic.getText(),
                    Integer.parseInt(txtAge.getText()),
                    Double.parseDouble(txtSalary.getText())
            );

            boolean updated = employeeService.updateEmployee(employeeDto);

            if (updated) {
                System.out.println("Success, Employee updated successfully!");

            } else {
                System.out.println("Error ,Update failed!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error, Age and Salary must be valid numbers");
        }
    }

}
