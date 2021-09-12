package th.in.dminer.tracingdemo;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogisticsService {
    @Autowired
    private Tracer tracer;

    public void transport(Span parentSpan) throws InterruptedException {
        Span span = tracer.buildSpan("transport").asChildOf(parentSpan).start();
        Thread.sleep((long)(Math.random() * 500));
        span.finish();
    }
}
