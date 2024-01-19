package com.wordwave.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping({"/", "/grammar"})
    public String redirect() {
        return "index.html";
    }
}
