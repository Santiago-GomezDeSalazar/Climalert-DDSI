package ar.edu.utn.ba.ddsi.climalert.repositories.weather.impl;

import ar.edu.utn.ba.ddsi.climalert.model.entities.Weather;
import ar.edu.utn.ba.ddsi.climalert.repositories.weather.IWeatherRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WeatherRepository implements IWeatherRepository {
  private final List<Weather> historial = new ArrayList<>();

  @Override
  public Weather save(Weather weather){
    historial.add(weather);
    return weather;
  }

  @Override
  public List<Weather> findAll(){
    return List.copyOf(historial);
  }

  @Override
  public Weather obtenerUltimoClima() {
    if (historial.isEmpty()) {
      return null;
    }

    return historial.getLast();
  }
}
