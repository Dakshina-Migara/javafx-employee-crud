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

public class SaveEmployeeController {

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

    //create the service layer object
    //because controller does not talk to database directly
    EmployeeService employeeService = new EmployeeServiceImpl();

    @FXML
    void save(ActionEvent event) {
        //create the employeeDto object
        EmployeeDto employeeDto = new EmployeeDto(
                txtName.getText(),
                txtNic.getText(),
                //convert to the String
                Integer.parseInt(txtAge.getText()),
                Double.parseDouble(txtSalary.getText())
        );

        //Sends DTO to service layer
        //employeeService → This is your service object (EmployeeServiceImpl)
        //saveEmployee(employeeDto) → This calls the saveEmployee method in the service layer
        //employeeDto → The object you created from the UI inputs (name, NIC, age, salary)
        //savedEmployeeDto → Stores the result returned by the service
        EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto);

        if (savedEmployeeDto != null) {
            System.out.println("Success , employee saved successfully");
        } else {
            System.out.println("error , employee saved failed");
        }
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        //get the current application window
        Stage stage = (Stage) this.root.getScene().getWindow();

        //load the home page ui
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-page.fxml"));
        //create the new scene
        Scene scene = new Scene(fxmlLoader.load());

        //Replaces current scene with home page
        stage.setScene(scene);
    }

}

//User Input (JavaFX Form)
//        ↓
//Controller (SaveEmployeeController)
//        ↓
//Create EmployeeDto object
//        ↓
//Call EmployeeService.saveEmployee(employeeDto)
//        ↓
//Service Layer (Logic)
//        ↓
//Get DB Connection (DBConnection.getInstance().getConnection())
//        ↓
//Prepare SQL & set parameters
//        ↓
//Execute SQL (INSERT into employee table)
//        ↓
//Return saved EmployeeDto or null
//        ↓
//Controller checks result
//        ↓
//Show success/failure message in UI
//
