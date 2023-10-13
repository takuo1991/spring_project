package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
@RequestMapping("calculator")
public class CalculatorController {

	private final CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@PostMapping("calculator")
	public String showForm() {
		return "calculator";
	}

	@PostMapping("/{formId}")
	    public String calculate(@PathVariable String formId, 
	                            @RequestParam(value = "from", defaultValue = "0") int from,
	                            @RequestParam(value = "subtract", defaultValue = "0") int subtract,  
	                            Model model) {

	        int result = calculatorService.calculator(from, subtract);

	        // formIdを基に属性を追加
	        model.addAttribute("result" + formId, result);

	        return "calculator";
	}
}