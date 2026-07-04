package ar.edu.utn.ba.ddsi.climalert.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherIDTO {
  private LocationIDTO location;
  private CurrentIDTO current;
}
