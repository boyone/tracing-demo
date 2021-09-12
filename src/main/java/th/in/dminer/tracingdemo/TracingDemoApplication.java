package th.in.dminer.tracingdemo;

import io.jaegertracing.Configuration;
import io.jaegertracing.internal.JaegerTracer;
import io.opentracing.Span;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TracingDemoApplication {

	private static JaegerTracer tracer;

	@RequestMapping("/checkout")
	public String checkout() {
		Span span = tracer.buildSpan("checkout").start();
		span.finish();
		return "You have successfully checked out your shopping cart.";
	}

	public static void main(String[] args) {
		tracer = Configuration.fromEnv("EShop").getTracer();
		SpringApplication.run(TracingDemoApplication.class, args);
	}

}
