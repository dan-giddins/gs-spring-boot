package com.example.springboot;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/teststreams")
	public String testStreams() {
		String[] myArray = { "asd", "sdfsdf", "fdsgjkdfsbgjklfdgnkldf", "sdfjksdf", "dfsd", "12345678",
				"sdfsdjksdfdsfdsfsdfdsfdsfdfsdjklfdsf" };
		var myList = Arrays.asList(myArray);
		var longest = myList.stream()
				.filter(x -> x.length() < 10)
				.map(x -> x.toUpperCase() + "upper")
				.reduce("BANANA",
						(curr, next) -> curr.length() > next.length()
								? curr
								: next);
		var tooBig = myList.stream()
				.filter(x -> x.length() >= 10)
				.collect(Collectors.toList());
		return longest + " but also " + tooBig.toString();
	}
}
