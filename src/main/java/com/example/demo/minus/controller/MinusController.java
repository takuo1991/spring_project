package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

@Controller
public class MinusController {

	private final MinusService minusService;

	public MinusController(MinusService minusService) {
		this.minusService = minusService;
	}

	@GetMapping("minus")
	public String showForm() {
		return "minus.html";
	}

	@PostMapping("minus")
	public String doGet(@RequestParam(value = "from", defaultValue = "0") int from,
			@RequestParam(value = "subtract", defaultValue = "0") int subtract, Model model) {

		model.addAttribute("from", from);
		model.addAttribute("subtract", subtract);

		String result = "";

		result = String.valueOf(minusService.minus(from, subtract));

		model.addAttribute("result", result);

		return "minus.html";
	}
}