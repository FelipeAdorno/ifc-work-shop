package br.com.ifc.resource;

import br.com.ifc.enums.FlagEnum;
import br.com.ifc.run.IFCSampleProject;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * The type Payment resource test.
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IFCSampleProject.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=8000", "management.port=0" })
@DirtiesContext
public class PaymentResourceTest extends TestCase {

    private static final String API_CONTEXT = "/gateway-api";
    private static final String LOCALHOST = "http://localhost:8000";
    private static final String PAYMENT = "/payment";

    @Test
    public void testPayCielo() throws Exception {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCardNumber("5465456456");
        paymentRequest.setFlag(FlagEnum.CIELO);

        ResponseEntity<PaymentResponse> paymentResponse = callAPItoPay(paymentRequest);
        assertEquals(HttpStatus.OK, paymentResponse.getStatusCode());
        assertEquals(new PaymentResponse(true), paymentResponse.getBody());
    }

    @Test
    public void testPayVisa() throws Exception {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCardNumber("5465456456");
        paymentRequest.setFlag(FlagEnum.VISA);

        ResponseEntity<PaymentResponse> paymentResponse = callAPItoPay(paymentRequest);
        assertEquals(HttpStatus.OK, paymentResponse.getStatusCode());
        assertEquals(new PaymentResponse(false), paymentResponse.getBody());
    }

    private ResponseEntity<PaymentResponse> callAPItoPay(final PaymentRequest paymentRequest) {
        return new TestRestTemplate().postForEntity(LOCALHOST + API_CONTEXT + PAYMENT, paymentRequest, PaymentResponse.class);
    }
}