package it.dst.server.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class WelcomeController {

	@GetMapping()
    public String getTest() {
    	return "index.html";
    }
}
