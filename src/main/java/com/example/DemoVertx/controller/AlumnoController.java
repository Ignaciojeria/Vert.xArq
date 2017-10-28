package com.example.DemoVertx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.DemoVertx.config.Api;
import com.example.DemoVertx.dao.AlumnoDAO;
import com.example.DemoVertx.service.AlumnoService;

import io.vertx.core.AsyncResult;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.EncodeException;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;


public class AlumnoController {

	private AlumnoDAO alumnoDao=AlumnoDAO.getInstance();
	
	@Autowired
	private Vertx vertx;
	/*
	public AlumnoController(Vertx vertx){
		 this.vertx=vertx;
	 }*/
	 
		public void holaMundo(Router router){
		    router.get(Api.HOLA).handler(routingContext->{HttpServerResponse response=routingContext.response();
			response.putHeader("content-type", "text/plain");
			response.end("Hola mundo desde vert.x");});
		}
		
		public void findAll(Router router){
			router.get(Api.ALUMNO).produces("application/json")
			.handler(this::findAllctx);
		}
		
		private void findAllctx(RoutingContext routingContext){
			HttpServerResponse response = routingContext.response();
			response.putHeader("content-type", "application/json");
			response.end(Json.encodePrettily(alumnoDao.findAll()));
		}
	    
}
