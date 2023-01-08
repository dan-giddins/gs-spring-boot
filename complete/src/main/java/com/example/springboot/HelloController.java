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

	@GetMapping("/testStream")
	public String testStream() {
		String[] array = { "asd", "sdfsdf", "fdsgjkdfsbgjklfdgnkldf", "sdfjksdf", "dfsd", "sdfsdjkfsdjklfdsf" };
		var list = Arrays.asList(array);
		var stream = list.stream();
		var filter = stream.filter(x -> x.length() > 5);
		// var map = filter.map(x -> x.toUpperCase());
		var map = filter.map(String::toUpperCase);
		var reduce = map.reduce(
				"BANANA",
				(curr, next) -> curr.length() > next.length()
						? curr
						: next);
		var collect = map.collect(Collectors.toList());
		return reduce;
	}
}
