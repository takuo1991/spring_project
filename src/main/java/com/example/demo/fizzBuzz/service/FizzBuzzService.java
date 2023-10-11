package com.example.demo.fizzBuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

	public List<String> fizzBuzzList() {
		List<String> results = new ArrayList<>();

		for (int i = 0; i <= 100; i++) {

			if (i % 3 == 0 && i % 5 == 0) {
				results.add("FizzBuzz");
			} else if (i % 5 == 0) {
				results.add("Buzz");
			} else if (i % 3 == 0) {
				results.add("Fizz");
			} else {
				results.add(Integer.toString(i));
			}
		}

		return results;
	}
}
