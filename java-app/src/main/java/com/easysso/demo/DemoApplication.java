package com.easysso.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> route(){
		return RouterFunctions
				.route(GET("/"), req -> ServerResponse.ok().body(BodyInserters.fromValue("Hello (secured) Java!")))
				.andRoute(GET("/headers"), req ->
						ServerResponse.ok().body(BodyInserters.fromValue(req.headers().toString())));
	}
}


