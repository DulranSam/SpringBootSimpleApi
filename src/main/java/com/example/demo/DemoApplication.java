package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, "--server.port=4000");

		String [] whatever = {"Hello","How","Are","You"};
		linearSearch(whatever,"hell");

	}

//	@GetMapping("home")
//	public List<Student> username() {
////		return List.of(new Student("asdodkas","oaskdasd","qweqwe",21,new Date(124, 1, 2)));
//	}

	public static void linearSearch(String[]array,String target){

		for(String iter : array){
			if(Objects.equals(iter,iter.startsWith(target))){
				System.out.println("Item found!");
			}else{
				System.out.println("Item not found!");
			}
		}
	}



	@GetMapping("home")
	public String whatever() {
		String request = "";
		try {

			HttpClient httpClient = HttpClient.newHttpClient();


			HttpRequest httpRequest = HttpRequest.newBuilder()
					.uri(new URI("https://yts.mx/api/v2/list_movies.json"))
					.GET()
					.build();


			HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());


			request = response.body();

		} catch (URISyntaxException | IOException | InterruptedException e) {

			e.printStackTrace();
		}

        return request;
	}




	@PostMapping("test")
	public List<String> testingPost(){
		return List.of("Hello","world");
	}
}
