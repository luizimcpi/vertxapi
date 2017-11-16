package com.concrete.vertxapi.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

	 @Override
	  public void start(Future<Void> fut) {

	    Router router = Router.router(vertx);

	    router.route("/").handler(routingContext -> {
	      HttpServerResponse response = routingContext.response();
	      response
	          .putHeader("content-type", "text/html")
	          .end("<h1>Meu Primeiro Server com Vertx Funcionando</h1>");
	    });

	    vertx
	        .createHttpServer()
	        .requestHandler(router::accept)
	        .listen(
	            config().getInteger("http.port", 9000),
	            result -> {
	              if (result.succeeded()) {
	                fut.complete();
	              } else {
	                fut.fail(result.cause());
	              }
	            }
	        );
	  }
	
}
