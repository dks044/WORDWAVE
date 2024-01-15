package com.wordwave.voca;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VocaController {
	
	@GetMapping("/vocatest")
	public String vocaQuizTestForm() {
		return "vocatest";
	}
	
}
