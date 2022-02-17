package com.weatherforecast.mavenweatherforecast;

import com.weatherapi.api.WeatherAPIClient;
import com.weatherapi.api.controllers.APIsController;
import com.weatherapi.api.models.Forecast;
import com.weatherapi.api.models.ForecastJsonResponse;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

public class WeatherManagerTest {

    @Test
    public void shouldGetForecast() throws Throwable {
        WeatherManager weatherManager = new WeatherManager();

        Forecast forecast = new Forecast();
        Forecast forecastSpy = Mockito.spy(forecast);
        Mockito.doReturn(null).when(forecastSpy).getForecastday();

        ForecastJsonResponse forecastJsonResponse = new ForecastJsonResponse();
        ForecastJsonResponse forecastJsonResponseSpy = Mockito.spy(forecastJsonResponse);
        Mockito.doReturn(forecastSpy).when(forecastJsonResponseSpy).getForecast();

        APIsController apisController = new APIsController();
        APIsController apisControllerSpy = Mockito.spy(apisController);
        Mockito.doReturn(forecastJsonResponseSpy).when(apisControllerSpy).getForecastWeather(anyString(), anyInt(), any(LocalDate.class), anyInt(), anyInt(), anyString());

        WeatherAPIClient weatherAPIClient = new WeatherAPIClient();
        WeatherAPIClient weatherAPIClientSpy = Mockito.spy(weatherAPIClient);
        Mockito.doReturn(apisControllerSpy).when(weatherAPIClientSpy).getAPIs();

        weatherManager.setClient(weatherAPIClientSpy);

        weatherManager.getForecast("Boston");

        ArgumentCaptor<String> cityCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Integer> daysCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<LocalDate> dtCaptor = ArgumentCaptor.forClass(LocalDate.class);
        ArgumentCaptor<Integer> unixdtCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> hourCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<String> langCaptor = ArgumentCaptor.forClass(String.class);

        Mockito.verify(apisControllerSpy).getForecastWeather(
                cityCaptor.capture(),
                daysCaptor.capture(),
                dtCaptor.capture(),
                unixdtCaptor.capture(),
                hourCaptor.capture(),
                langCaptor.capture()
        );

        assertEquals(cityCaptor.getValue(), "Boston");

    }
}
