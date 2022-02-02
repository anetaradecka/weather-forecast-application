package main.java.weatherforecast.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Forecast {
    private SimpleStringProperty date;
    private SimpleDoubleProperty temp;
    private SimpleStringProperty condition;

    public Forecast(String date, Double temp, String condition) {
        this.date = new SimpleStringProperty(date);
        this.temp = new SimpleDoubleProperty(temp);
        this.condition = new SimpleStringProperty(condition);
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public SimpleDoubleProperty tempProperty() {
        return temp;
    }

    public SimpleStringProperty conditionProperty() {
        return condition;
    }

}
