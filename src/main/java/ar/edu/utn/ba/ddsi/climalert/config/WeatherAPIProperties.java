package ar.edu.utn.ba.ddsi.climalert.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "weather.api")
public class WeatherAPIProperties {

  private String url;
  private String key;
  private String location;

}
