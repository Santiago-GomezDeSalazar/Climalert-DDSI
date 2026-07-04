package ar.edu.utn.ba.ddsi.climalert.serviciosExternos.weatherApi;
import ar.edu.utn.ba.ddsi.climalert.model.dto.WeatherIDTO;

public interface IWeatherAdapter {
  WeatherIDTO obtenerClima();
}
