package com.example.demo;

import com.example.demo.student.Student;
import com.example.demo.student.SubMovie;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpsParameters;
import jakarta.websocket.server.PathParam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.*;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, "--server.port=4000");

		String [] whatever = {"Hello","How","Are","You"};
		linearSearch(whatever,"hell");

		SubMovie data = new SubMovie("terrifier","Something!");
		System.out.println(data);

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
	public HashMap<String, Object> whatever(@RequestParam(name = "query_term", required = false) String queryTerm) {
		HashMap<String, Object> resultMap = new HashMap<>();

		try {
			String apiUrl = "https://yts.mx/api/v2/list_movies.json";
			if (queryTerm != null && !queryTerm.isEmpty()) {
				apiUrl += "?query_term=" + URLEncoder.encode(queryTerm, StandardCharsets.UTF_8.toString());
			}

			HttpClient httpClient = HttpClient.newHttpClient();

			HttpRequest httpRequest = HttpRequest.newBuilder()
					.uri(new URI(apiUrl))
					.GET()
					.build();

			HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

			ObjectMapper objectMapper = new ObjectMapper();
			HashMap<String, Object> responseData = objectMapper.readValue(response.body(), HashMap.class);

			resultMap.put("status", response.statusCode());
			resultMap.put("data", responseData);

		} catch (URISyntaxException | IOException | InterruptedException e) {
			e.printStackTrace();
			resultMap.put("error", e.getMessage());
		}

		return resultMap;
	}



	@GetMapping("yolo")
	public HashMap<String,String> JSON(){
		HashMap<String,String> data = new HashMap<>();
		data.put("Yes", "what");
		data.put("No", "why");
		data.put("Hello", "world");
		data.put("Java", "programming");
		data.put("OpenAI", "GPT-3.5");
		data.put("Coffee", "brew");
		return data;
	}

	@GetMapping(path = "{studentId}")
	public String idWise(@PathVariable("studentId") Long id){
		return "This is the ID -> "+id;
	}




	@GetMapping("/test")
	public Map<String, String> testingPost() {
		Map<String, String> response = new HashMap<>();
		response.put("username", "veloxal");
		response.put("password", "velo123");
		return response;
	}
}
