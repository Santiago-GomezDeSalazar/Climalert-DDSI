package ar.edu.utn.ba.ddsi.climalert.repositories.weather;

import ar.edu.utn.ba.ddsi.climalert.model.entities.Weather;
import java.util.List;

public interface IWeatherRepository {
  Weather save(Weather weather);
  List<Weather> findAll();
  Weather obtenerUltimoClima();
}
