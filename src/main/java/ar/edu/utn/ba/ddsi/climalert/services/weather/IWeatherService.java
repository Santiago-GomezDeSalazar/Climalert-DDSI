package ar.edu.utn.ba.ddsi.climalert.services.weather;

import ar.edu.utn.ba.ddsi.climalert.model.entities.Weather;

public interface IWeatherService {
  public Weather actualizarClima();
  public void analizarAlertas();

}
