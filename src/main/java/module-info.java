module com.company.javapractice8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.company.javapractice8 to javafx.fxml;
    exports com.company.javapractice8;
}