package br.com.ifc.service.provider;

import br.com.ifc.resource.PaymentRequest;
import br.com.ifc.resource.PaymentResponse;
import br.com.ifc.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * The type Pay cielo service provider.
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@Service
public class PayCieloServiceProvider implements PaymentService {

    @Override
    public PaymentResponse pay(final PaymentRequest paymentRequest) {
        return new PaymentResponse(true);
    }

}
