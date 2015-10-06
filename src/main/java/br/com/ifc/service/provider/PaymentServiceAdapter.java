package br.com.ifc.service.provider;

import br.com.ifc.resource.PaymentRequest;
import br.com.ifc.resource.PaymentResponse;
import br.com.ifc.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Payment service adapter.
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@Service
public class PaymentServiceAdapter implements PaymentService {

    @Autowired
    private PaymentService payCieloServiceProvider;
    @Autowired
    private PaymentService payVisaServiceProvider;

    @Override
    public PaymentResponse pay(final PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = null;
        switch (paymentRequest.getFlag()) {
            case VISA:
                paymentResponse = payVisaServiceProvider.pay(paymentRequest);
                break;
            case CIELO:
                paymentResponse = payCieloServiceProvider.pay(paymentRequest);
                break;
        }
        return paymentResponse;
    }

}
