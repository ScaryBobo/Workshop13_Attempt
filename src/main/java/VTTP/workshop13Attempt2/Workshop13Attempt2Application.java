package VTTP.workshop13Attempt2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop13Attempt2Application {

	public static String dataDIR = "/users/leslielow/data_1";

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Workshop13Attempt2Application.class); 
	
		try{
			Path path = Paths.get(dataDIR);
			Files.createDirectories(path);
			System.out.println("directory is created");

		} catch (IOException e){

			System.err.println("Failed to create directory!" + e.getMessage());
		}
		
		app.run(args);
		//mvn spring-boot:run -Dspring-boot.run.arguments=--dataDIR
	}

}
