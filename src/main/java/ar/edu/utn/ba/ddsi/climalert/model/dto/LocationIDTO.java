package ar.edu.utn.ba.ddsi.climalert.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class LocationIDTO {
  private String name;
  private String region;
  private String country;
  private String localtime;
}
