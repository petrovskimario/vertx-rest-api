package com.iwlabs.vertx4.reactive.rest.api.api.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

  private Integer id;
  private String title;

}
