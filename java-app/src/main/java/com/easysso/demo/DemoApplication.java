package com.easysso.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Collections;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> route(){
		return RouterFunctions
				.route(GET("/"),
						request -> ServerResponse.ok().contentType(MediaType.TEXT_HTML).render("hello.html"))
				.andRoute(GET("/headers"), req ->
						ServerResponse.ok().contentType(MediaType.TEXT_HTML)
								.render("headers.html", Collections.singletonMap("headers",req.headers().asHttpHeaders())));
	}
}


