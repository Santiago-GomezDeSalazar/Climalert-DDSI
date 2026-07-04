package ar.edu.utn.ba.ddsi.climalert.schedulers;

import ar.edu.utn.ba.ddsi.climalert.services.weather.IWeatherService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherScheduler {
  private final IWeatherService weatherService;

  public WeatherScheduler(IWeatherService weatherService) {
    this.weatherService = weatherService;
  }

  @Scheduled(cron = "0 */5 * * * *")
  public void actualizarClima() {
    weatherService.actualizarClima();
  }

  @Scheduled(cron = "0 * * * * *")
  public void analizarAlertas() {
    weatherService.analizarAlertas();
  }
}
