package th.in.dminer.tracingdemo;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EShopController {

    @Autowired
    private Tracer tracer;

    @RequestMapping("/checkout")
    public String checkout() {
        Span span = tracer.buildSpan("checkout").start();
        span.finish();
        return "You have successfully checked out your shopping cart.";
    }
}