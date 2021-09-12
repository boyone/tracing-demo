package th.in.dminer.tracingdemo;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    private Tracer tracer;

    @Autowired
    private LogisticsService logisticsService;

    public void arrangeDelivery(Span parentSpan) throws InterruptedException {
        Span span = tracer.buildSpan("arrange-delivery").asChildOf(parentSpan).start();
        Thread.sleep((long)(Math.random() * 500));
        logisticsService.transport(span);
        span.finish();
    }
}
