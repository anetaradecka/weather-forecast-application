module WeatherForecast {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;

    opens com.weatherforecast;
    opens com.weatherforecast.controller;
    opens com.weatherforecast.view;
}