package com.weatherforecast.mavenweatherforecast.controller;

import com.weatherapi.api.models.Forecastday;
import com.weatherforecast.mavenweatherforecast.WeatherManager;
import com.weatherforecast.mavenweatherforecast.model.Forecast;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    WeatherManager weatherManager = new WeatherManager();

    @FXML
    public Button checkForecastButton;

    @FXML
    public Label primaryErrorLabel;

    @FXML
    public Label secondaryErrorLabel;

    public WeatherManager getWeatherManager() {
        return weatherManager;
    }

    public void setWeatherManager(WeatherManager weatherManager) {
        this.weatherManager = weatherManager;
    }

    public TextField getPrimaryTextField() {
        return primaryTextField;
    }

    public void setPrimaryTextField(TextField primaryTextField) {
        this.primaryTextField = primaryTextField;
    }

    public TextField getSecondaryTextField() {
        return secondaryTextField;
    }

    public void setSecondaryTextField(TextField secondaryTextField) {
        this.secondaryTextField = secondaryTextField;
    }

    @FXML
    public TextField primaryTextField;

    @FXML
    public TextField secondaryTextField;

    @FXML
    public TableView<Forecast> primaryTableView;

    @FXML
    public TableView<Forecast> secondaryTableView;

    @FXML
    void checkForecastAction() {
        boolean primaryFieldIsValid = isPrimaryFieldValid();
        boolean secondaryFieldIsValid = isSecondaryFieldValid();

        if (primaryFieldIsValid && secondaryFieldIsValid) {
            try {
                // Zwraca List<Forecastday>
                List<Forecastday> primaryCity = weatherManager.getForecast(primaryTextField.getText());

                // Przygotowujemy zawartosc TableView
                ObservableList<Forecast> primaryTableViewData = FXCollections.observableArrayList();

                for (Forecastday day : primaryCity) {
                    primaryTableViewData.add(new Forecast(
                            day.getDate(),
                            day.getDay().getAvgtempC(),
                            day.getDay().getCondition().getText()
                    ));
                }

                primaryTableView.setItems(primaryTableViewData);
                primaryTableView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("date"));
                primaryTableView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("temp"));
                primaryTableView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("condition"));
            } catch (Throwable e) {
                e.printStackTrace();
            }

            try {
                // Zwraca List<Forecastday>
                List<Forecastday> secondaryCity = weatherManager.getForecast(secondaryTextField.getText());

                // Przygotowujemy zawartosc TableView
                ObservableList<Forecast> secondaryTableViewData = FXCollections.observableArrayList();

                for (Forecastday day : secondaryCity) {
                    secondaryTableViewData.add(new Forecast(
                            day.getDate(),
                            day.getDay().getAvgtempC(),
                            day.getDay().getCondition().getText()
                    ));
                }

                secondaryTableView.setItems(secondaryTableViewData);
                secondaryTableView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("date"));
                secondaryTableView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("temp"));
                secondaryTableView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("condition"));
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public boolean isPrimaryFieldValid() {
        if (primaryTextField.getText().isEmpty()) {
            primaryErrorLabel.setText("Required");
            return false;
        }
        primaryErrorLabel.setText("");
        return true;
    }

    public boolean isSecondaryFieldValid() {
        if (secondaryTextField.getText().isEmpty()) {
            secondaryErrorLabel.setText("Required");
            return false;
        }
        secondaryErrorLabel.setText("");
        return true;
    }

}
