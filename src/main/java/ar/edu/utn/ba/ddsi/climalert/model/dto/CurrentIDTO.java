package ar.edu.utn.ba.ddsi.climalert.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentIDTO {
  private Double temp_c;
  private ConditionIDTO condition;
  private Integer humidity;
  private String last_updated;
}
