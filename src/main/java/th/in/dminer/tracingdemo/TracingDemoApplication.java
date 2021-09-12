package th.in.dminer.tracingdemo;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TracingDemoApplication {

	@Bean
	public Tracer getTracer() {
		return Configuration.fromEnv("EShop").getTracer();
	}

	public static void main(String[] args) {
		SpringApplication.run(TracingDemoApplication.class, args);
	}

}
