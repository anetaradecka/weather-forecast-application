package main.java.weatherforecast;

import com.weatherapi.api.WeatherAPIClient;
import com.weatherapi.api.models.Forecastday;

import java.util.ArrayList;
import java.util.List;

public class WeatherManager {

    private final String key = "cfb31c2ead9c45b48b9133259221901";

    private final WeatherAPIClient client = new WeatherAPIClient(key);

    public List<Forecastday> getForecast(String cityName) throws Throwable {
        try {
            return client
                    .getAPIs()
                    .getForecastWeather(cityName, 3, null, null, null, null)
                    .getForecast()
                    .getForecastday();

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
