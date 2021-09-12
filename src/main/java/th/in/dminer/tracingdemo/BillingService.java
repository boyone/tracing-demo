package th.in.dminer.tracingdemo;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
    @Autowired
    private Tracer tracer;

    public void payment(Span checkoutSpan) throws InterruptedException {
        Span span = tracer.buildSpan("payment").asChildOf(checkoutSpan).start();
        Thread.sleep((long)(Math.random() * 500));
        span.finish();
    }
}
