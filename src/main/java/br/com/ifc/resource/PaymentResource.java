package br.com.ifc.resource;

import br.com.ifc.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Freight resource.
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@RestController
@RequestMapping(value = "/payment")
public class PaymentResource {

    @Autowired
    private PaymentService paymentServiceAdapter;

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity<PaymentResponse> pay(@RequestBody final PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = paymentServiceAdapter.pay(paymentRequest);
        return new ResponseEntity<PaymentResponse>(paymentResponse, HttpStatus.OK);
    }
}
