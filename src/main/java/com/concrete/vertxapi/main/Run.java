package com.concrete.vertxapi.main;

import com.concrete.vertxapi.server.ServerVerticle;

import io.vertx.core.Vertx;

public class Run {

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new ServerVerticle());
		System.out.println(">>> Verticle iniciado e rodando na porta 9000");
	}

}
