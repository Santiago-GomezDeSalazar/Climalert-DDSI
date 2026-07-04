package ar.edu.utn.ba.ddsi.climalert.model.entities;

import ar.edu.utn.ba.ddsi.climalert.model.dto.WeatherIDTO;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class Weather {
  private Double temperatura;
  private Integer humedad;
  private String localidad;
  private LocalDateTime fechaHora;
  private String estadoClima;

  public Weather(WeatherIDTO dto) {
    this.temperatura = dto.getCurrent().getTemp_c();
    this.humedad = dto.getCurrent().getHumidity();
    this.localidad = dto.getLocation().getName();
    this.fechaHora = LocalDateTime.now();
    this.estadoClima = dto.getCurrent().getCondition().getText();
  }

  public Boolean hayAlerta(){
    return temperatura > 35 && humedad > 60;
  }

}
