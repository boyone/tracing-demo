package th.in.dminer.tracingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TracingDemoApplication {

	@RequestMapping("/checkout")
	public String home() {
		return "You have successfully checked out your shopping cart.";
	}

	public static void main(String[] args) {
		SpringApplication.run(TracingDemoApplication.class, args);
	}

}
