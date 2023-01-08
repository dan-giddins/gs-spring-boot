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

	@GetMapping("/teststream")
	public String testStream() {
		String[] array = { "asd", "sdfsdf", "fdsgjkdfsbgjklfdgnkldf", "sdfjksdf", "dfsd", "123456789",
				"sdfsdjksdfdsfdsfsdfdsfdsfdfsdjklfdsf" };
		var list = Arrays.asList(array);
		var longest = list.stream()
				.filter(x -> x.length() < 10)
				.map(x -> x.toUpperCase() + "upper")
				.reduce(
						"BANANA",
						(curr, next) -> curr.length() > next.length()
								? curr
								: next);
		var tooBig = list.stream()
				.filter(x -> x.length() >= 10)
				.collect(Collectors.toList());
		return longest + " but also " + tooBig.toString();
	}
}
