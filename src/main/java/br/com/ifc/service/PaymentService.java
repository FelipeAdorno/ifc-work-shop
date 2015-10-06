package br.com.ifc.service;

import br.com.ifc.resource.PaymentRequest;
import br.com.ifc.resource.PaymentResponse;

/**
 * The interface Payment service.
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public interface PaymentService {

    /**
     * Pay payment response.
     *
     * @param paymentRequest the payment request
     * @return the payment response
     */
    PaymentResponse pay(PaymentRequest paymentRequest);

}
