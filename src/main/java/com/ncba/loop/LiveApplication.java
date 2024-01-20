package com.ncba.loop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info= @Info(title="Cards Microservice", version="1.0", description="Welcome to Loop DFS, a Fintech company which provides banking solutions such as card\n"
		+ "management (virtual or real), accounts, payments, transfers and expense management to other\n"
		+ "financial institutions.", license = @License( name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html"), contact = @Contact(  name = "Loop DFS Support", email = "support@loopdfs.com", url = "https://www.loopdfs.com" ) ))
public class LiveApplication {

	public static void main(String[] args) {
		System.out.println("Go for it!---->>>>>");
		SpringApplication.run(LiveApplication.class, args);
	}

}
