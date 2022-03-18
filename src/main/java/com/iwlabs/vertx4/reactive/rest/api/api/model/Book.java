package com.iwlabs.vertx4.reactive.rest.api.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    private Integer id;
    private String title;

}
