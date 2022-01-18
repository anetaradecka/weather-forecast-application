module JavaFXEmailClientCourse {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires activation;
    requires java.mail;

    opens com.barosanu;
    opens com.barosanu.controller;
    opens com.barosanu.view;
    opens com.barosanu.model;
}