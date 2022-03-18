package com.iwlabs.vertx4.reactive.rest.api.verticle;

import com.iwlabs.vertx4.reactive.rest.api.api.repository.BookRepository;
import com.iwlabs.vertx4.reactive.rest.api.utils.ConfigUtils;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.pgclient.PgPool;
import com.iwlabs.vertx4.reactive.rest.api.api.handler.BookHandler;
import com.iwlabs.vertx4.reactive.rest.api.api.handler.ErrorHandler;
import com.iwlabs.vertx4.reactive.rest.api.api.router.BookRouter;
import com.iwlabs.vertx4.reactive.rest.api.api.service.BookService;
import com.iwlabs.vertx4.reactive.rest.api.utils.DbUtils;
import com.iwlabs.vertx4.reactive.rest.api.utils.LogUtils;

public class ApiVerticle extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiVerticle.class);

    @Override
    public void start(Promise<Void> promise) {
        final PgPool dbClient = DbUtils.buildDbClient(vertx);

        final BookRepository bookRepository = new BookRepository();
        final BookService bookService = new BookService(dbClient, bookRepository);
        final BookHandler bookHandler = new BookHandler(bookService);
        final BookRouter bookRouter = new BookRouter(vertx, bookHandler);

        final Router router = Router.router(vertx);
        ErrorHandler.buildHandler(router);
        bookRouter.setRouter(router);

        buildHttpServer(vertx, promise, router);
    }

    private void buildHttpServer(Vertx vertx,
                                 Promise<Void> promise,
                                 Router router) {
        int port = ConfigUtils.getInstance().getApplicationUtils().getServerPort();

        vertx.createHttpServer()
                .requestHandler(router)
                .listen(port, http -> {
                    if (http.succeeded()) {
                        promise.complete();
                        LOGGER.info(LogUtils.RUN_HTTP_SERVER_SUCCESS_MESSAGE.buildMessage(port));
                    } else {
                        promise.fail(http.cause());
                        LOGGER.info(LogUtils.RUN_HTTP_SERVER_ERROR_MESSAGE.buildMessage());
                    }
                });
    }

}
