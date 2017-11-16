package com.concrete.vertxapi.server;

import java.util.Map;
import java.util.TreeMap;

import com.concrete.vertxapi.entities.Contato;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class ServerVerticle extends AbstractVerticle {

	private Map<Integer, Contato> contatos = new TreeMap<>();

	@Override
	public void start(Future<Void> future) {

		mockContato();

		Router router = Router.router(vertx);

		router.route("/").handler(routingContext -> {
			HttpServerResponse response = routingContext.response();
			response.putHeader("content-type", "text/html").end("<h1>Meu Primeiro Server com Vertx Funcionando</h1>");
		});

		router.post("/api/contatos").handler(this::addContato);
		router.get("/api/contatos").handler(this::getAll);

		vertx.createHttpServer().requestHandler(router::accept).listen(config().getInteger("http.port", 9000),
				result -> {
					if (result.succeeded()) {
						future.complete();
					} else {
						future.fail(result.cause());
					}
				});
	}

	private void addContato(RoutingContext routingContext) {
		final Contato contato = Json.decodeValue(routingContext.getBodyAsString(), Contato.class);

		contatos.put(contato.getId(), contato);

		routingContext.response().setStatusCode(201).putHeader("content-type", "application/json; charset=utf-8")
				.end(Json.encodePrettily(contato));
	}

	private void getAll(RoutingContext routingContext) {
		routingContext.response().putHeader("content-type", "application/json; charset=utf-8")
				.end(Json.encodePrettily(contatos.values()));
	}

	private void mockContato() {
		Contato contatoPolitico = new Contato("Protogenes Torres", "(11) 3222-2222");
		contatos.put(contatoPolitico.getId(), contatoPolitico);
		Contato contatoNegocios = new Contato("Armenio Mendes", "(11) 2121-0909");
		contatos.put(contatoNegocios.getId(), contatoNegocios);
	}

}
