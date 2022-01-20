package com.weatherforecast.controller;

import com.weatherapi.api.models.Forecastday;
import com.weatherforecast.WeatherManager;
import com.weatherforecast.model.Forecast;
import com.weatherforecast.view.ViewFactory;
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
    private Button checkForecastButton;

    @FXML
    private Label primaryErrorLabel;

    @FXML
    private Label secondaryErrorLabel;

    @FXML
    private TextField primaryTextField;

    @FXML
    private TextField secondaryTextField;

    @FXML
    private TableView<Forecast> primaryTableView;

    @FXML
    private TableView<Forecast> secondaryTableView;

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
                            day.getDay().getCondition().getText(),
                            day.getDay().getCondition().getIcon()
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
                            day.getDay().getCondition().getText(),
                            day.getDay().getCondition().getIcon()
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

    private boolean isPrimaryFieldValid() {
        if (primaryTextField.getText().isEmpty()) {
            primaryErrorLabel.setText("Required");
            return false;
        }
        primaryErrorLabel.setText("");
        return true;
    }

    private boolean isSecondaryFieldValid() {
        if (secondaryTextField.getText().isEmpty()) {
            secondaryErrorLabel.setText("Required");
            return false;
        }
        secondaryErrorLabel.setText("");
        return true;
    }

}
