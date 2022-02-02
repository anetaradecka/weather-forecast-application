module WeatherForecast {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires java.net.http;
    requires weather.apilib;
    requires org.junit.jupiter.api;
    requires org.junit.jupiter.engine;
    requires org.junit.platform.commons;
    requires org.junit.platform.launcher;
    requires org.mockito.junit.jupiter;
    requires org.mockito;
    requires net.bytebuddy;
    requires org.testfx.junit5;

    // MAIN
    opens main.java.weatherforecast;
    opens main.java.weatherforecast.controller;
    opens main.java.weatherforecast.view;
    opens main.java.weatherforecast.model;

    // TEST
    opens test.java.weatherforecast.controller;

    exports test.java.weatherforecast.controller;
}