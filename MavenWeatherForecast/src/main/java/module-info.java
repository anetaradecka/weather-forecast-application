module com.weatherforecast.mavenweatherforecast {
    requires javafx.controls;
    requires javafx.fxml;

    requires weather.apilib;
    opens com.weatherforecast.mavenweatherforecast to javafx.fxml;
    exports com.weatherforecast.mavenweatherforecast;
}