package br.com.ifc.service.provider;

import br.com.ifc.resource.PaymentRequest;
import br.com.ifc.resource.PaymentResponse;
import br.com.ifc.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * The type Pay visa service provider.
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@Service
public class PayVisaServiceProvider implements PaymentService {

    @Override
    public PaymentResponse pay(final PaymentRequest paymentRequest) {
        return new PaymentResponse(false);
    }

}
