package com.iwlabs.vertx4.reactive.rest.api.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookGetByIdResponse implements Serializable {

  @JsonProperty(value = "id")
  private int id;

  @JsonProperty(value = "title")
  private String title;


  public BookGetByIdResponse(Book book) {
    this.id = book.getId();
    this.title = book.getTitle();
  }

}
