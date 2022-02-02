module com.weatherforecast.mavenweatherforecast {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.weatherforecast.mavenweatherforecast to javafx.fxml;
    exports com.weatherforecast.mavenweatherforecast;
}