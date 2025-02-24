package it.dst.server.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/")
    public String getTest() {
		String howTo="PATH http://localhost:8080/api/users/";
    	return howTo;
    }
}
