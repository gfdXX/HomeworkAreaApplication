module com.example.homeworkareaapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.homeworkareaapplication to javafx.fxml;
    exports com.example.homeworkareaapplication;
}