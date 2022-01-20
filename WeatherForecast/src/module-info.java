module WeatherForecast {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires java.net.http;
    requires weather.apilib;

    opens com.weatherforecast;
    opens com.weatherforecast.controller;
    opens com.weatherforecast.view;
    opens com.weatherforecast.model;
}