package ar.edu.utn.ba.ddsi.climalert.services.weather.impl;

import ar.edu.utn.ba.ddsi.climalert.model.dto.WeatherIDTO;
import ar.edu.utn.ba.ddsi.climalert.model.entities.Weather;
import ar.edu.utn.ba.ddsi.climalert.repositories.weather.IWeatherRepository;
import ar.edu.utn.ba.ddsi.climalert.services.weather.IWeatherService;
import ar.edu.utn.ba.ddsi.climalert.serviciosExternos.sendGrid.IServicioMensajeriaMailAdapter;
import ar.edu.utn.ba.ddsi.climalert.serviciosExternos.weatherApi.IWeatherAdapter;
import org.springframework.stereotype.Service;

@Service
public class WeatherService implements IWeatherService {
  private final IWeatherAdapter weatherAdapter;
  private final IWeatherRepository weatherRepository;
  private final IServicioMensajeriaMailAdapter mailAdapter;

  public WeatherService(IWeatherAdapter weatherAdapter, IWeatherRepository weatherRepository, IServicioMensajeriaMailAdapter mailAdapter) {
    this.weatherAdapter = weatherAdapter;
    this.weatherRepository = weatherRepository;
    this.mailAdapter = mailAdapter;
  }

  @Override
  public Weather actualizarClima(){
    WeatherIDTO weatherIDTO = weatherAdapter.obtenerClima();
    Weather weather =  new Weather(weatherIDTO);
    this.weatherRepository.save(weather);
    return weather;
  }

  @Override
  public Weather obtenerUltimoClima() {
    return weatherRepository.obtenerUltimoClima();
  }

  public void analizarAlertas() {
    Weather weather = weatherRepository.obtenerUltimoClima();
    if (weather != null && weather.hayAlerta()) {
      enviarAlerta(weather);
    }
  }

  private void enviarAlerta(Weather weather) {
    String asunto = "Alerta meteorológica";

    String mensaje =
        "Se detectaron condiciones climáticas críticas.\n\n" +
            "Localidad: " + weather.getLocalidad() + "\n" +
            "Temperatura: " + weather.getTemperatura() + " °C\n" +
            "Humedad: " + weather.getHumedad() + "%\n" +
            "Estado: " + weather.getEstadoClima() + "\n" +
            "Fecha: " + weather.getFechaHora();

    mailAdapter.sendEmail("admin@clima.com", asunto, mensaje);
    mailAdapter.sendEmail("emergencias@clima.com", asunto, mensaje);
    mailAdapter.sendEmail("meteorologia@clima.com", asunto, mensaje);
  }

}
