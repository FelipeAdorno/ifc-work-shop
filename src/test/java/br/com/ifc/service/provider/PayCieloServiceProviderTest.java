package br.com.ifc.service.provider;

import br.com.ifc.resource.PaymentRequest;
import br.com.ifc.resource.PaymentResponse;
import br.com.ifc.service.PaymentService;
import junit.framework.TestCase;

/**
 * The type Pay cielo service provider test.
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public class PayCieloServiceProviderTest extends TestCase {

    private PaymentService paymentService = new PayCieloServiceProvider();

    public void testPay() throws Exception {
        PaymentResponse paymentResponse = paymentService.pay(new PaymentRequest());
        assertEquals(expectedPaymentResponse(), paymentResponse);
    }

    private PaymentResponse expectedPaymentResponse() {
        return new PaymentResponse(true);
    }
}