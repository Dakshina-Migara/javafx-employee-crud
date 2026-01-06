module com.example.practice {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.practice to javafx.fxml;
    opens com.example.practice.controller to javafx.fxml;
    exports com.example.practice;
}
