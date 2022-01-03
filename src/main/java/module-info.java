module com.company.javapractice8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens com.company.javapractice8 to javafx.fxml;
    opens com.company.javapractice8.entities to javafx.fxml;
    opens com.company.javapractice8.controller to javafx.fxml;

    exports com.company.javapractice8.entities;
    exports com.company.javapractice8.controller;
    exports com.company.javapractice8;
}