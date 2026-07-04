package ar.edu.utn.ba.ddsi.climalert.serviciosExternos.weatherApi.impl;

import ar.edu.utn.ba.ddsi.climalert.model.dto.WeatherIDTO;
import ar.edu.utn.ba.ddsi.climalert.serviciosExternos.weatherApi.IWeatherAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class WeatherAdapter implements IWeatherAdapter {
  RestClient webClient;
  private final String apiKey;
  private final String location;

  public WeatherAdapter(
      RestClient.Builder builder,
      @Value("${weather.api.url}") String baseUrl,
      @Value("${weather.api.key}") String apiKey,
      @Value("${weather.api.location}") String location) {

    this.apiKey = apiKey;
    this.location = location;

    this.webClient = builder
        .baseUrl(baseUrl)
        .build();
  }

  @Override
  public WeatherIDTO obtenerClima() {
    try {
      return webClient.get()
          .uri(uriBuilder -> uriBuilder
              .path("/v1/current.json")
              .queryParam("key", apiKey)
              .queryParam("q", location)
              .build())
          .retrieve()
          .body(WeatherIDTO.class);

    } catch (Exception e) {
      throw new RuntimeException("Error al obtener el clima desde WeatherAPI", e);
    }
  }
  }

