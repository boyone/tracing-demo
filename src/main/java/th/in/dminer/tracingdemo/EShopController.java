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

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private BillingService billingService;

    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping("/checkout")
    public String checkout() throws Exception {
        Span checkoutSpan = tracer.buildSpan("checkout").start();
        inventoryService.createOrder(checkoutSpan);
        billingService.payment(checkoutSpan);
        deliveryService.arrangeDelivery(checkoutSpan);
        checkoutSpan.finish();
        return "You have successfully checked out your shopping cart.";
    }
}