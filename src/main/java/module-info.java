module com.example.practice {
    requires javafx.controls;
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires java.sql;
    opens com.example.practice.controller to javafx.fxml;
    opens com.example.practice.employeeDto to javafx.fxml, javafx.base;
    exports com.example.practice;
}