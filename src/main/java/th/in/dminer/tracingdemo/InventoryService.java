package th.in.dminer.tracingdemo;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    private Tracer tracer;

    public void createOrder(Span checkoutSpan) throws InterruptedException {
        Span span = tracer.buildSpan("create-order").asChildOf(checkoutSpan).start();
        Thread.sleep((long)(Math.random() * 500));
        span.finish();
    }
}
