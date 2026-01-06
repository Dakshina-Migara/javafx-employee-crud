package com.example.practice.controller;

import com.example.practice.employeeDto.EmployeeDto;
import com.example.practice.service.EmployeeService;
import com.example.practice.service.impl.EmployeeServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SaveEmployeeController {
    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtSalary;

    EmployeeService employeeService = new EmployeeServiceImpl();

    @FXML
    void save(ActionEvent event) {
        EmployeeDto employeeDto = new EmployeeDto(
                txtName.getText(),
                txtNic.getText(),
                Integer.parseInt(txtAge.getText()),
                Double.parseDouble(txtSalary.getText())
        );

        EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto);

        if (savedEmployeeDto != null) {
            System.out.println("Success , employee saved successfully");
        } else {
            System.out.println("error , employee saved failed");
        }
    }

    @FXML
    void back(ActionEvent event) {

    }

}
