package br.com.ifc.service.provider;

import br.com.ifc.resource.PaymentRequest;
import br.com.ifc.resource.PaymentResponse;
import br.com.ifc.service.PaymentService;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * The type Pay visa service provider test.
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public class PayVisaServiceProviderTest extends TestCase {

    private PaymentService paymentService = new PayVisaServiceProvider();

    @Test
    public void testPay() throws Exception {
        PaymentResponse paymentResponse = paymentService.pay(new PaymentRequest());
        assertEquals(expectedPaymentResponse(), paymentResponse);
    }

    private PaymentResponse expectedPaymentResponse() {
        return new PaymentResponse(false);
    }


}