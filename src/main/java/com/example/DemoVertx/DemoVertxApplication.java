package com.example.DemoVertx;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.DemoVertx.server.ServerLauncher;
import com.example.DemoVertx.server.ServerVerticle;

import io.vertx.core.AbstractVerticle;

import io.vertx.core.Vertx;

@SpringBootApplication
public class DemoVertxApplication extends AbstractVerticle {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(DemoVertxApplication.class, args);
		final Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(context.getBean(ServerLauncher.class));
	}
}
