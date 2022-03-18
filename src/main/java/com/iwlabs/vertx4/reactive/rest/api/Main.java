package com.iwlabs.vertx4.reactive.rest.api;

import com.iwlabs.vertx4.reactive.rest.api.verticle.MainVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class Main {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(MainVerticle.class.getName())
                .onFailure(throwable -> System.exit(-1))
                .onSuccess(res -> System.out.println("Success"));
    }

}
