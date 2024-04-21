package ir.najaftech.springboot.mysecondwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SayHelloController {


	@RequestMapping("say-hello")
	public String sayHello(@RequestParam String name) {
		return "say-hello";
	}
	
}
