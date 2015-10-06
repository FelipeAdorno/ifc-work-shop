package br.com.ifc.service.provider;

import br.com.ifc.enums.FlagEnum;
import br.com.ifc.resource.PaymentRequest;
import br.com.ifc.resource.PaymentResponse;
import br.com.ifc.service.PaymentService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * The type Payment service adapter test.
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceAdapterTest extends TestCase {

    @Mock
    private PaymentService payCieloServiceProvider;
    @Mock
    private PaymentService payVisaServiceProvider;
    @InjectMocks
    private PaymentService paymentServiceAdapter = new PaymentServiceAdapter();

    @Test
    public void testPayCielo() throws Exception {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCardNumber("6545645645645");
        paymentRequest.setFlag(FlagEnum.CIELO);

        when(payCieloServiceProvider.pay(paymentRequest)).thenReturn(expectedPaymentResponsePayed());

        PaymentResponse paymentResponse = paymentServiceAdapter.pay(paymentRequest);

        InOrder inOrder = inOrder(payCieloServiceProvider);
        inOrder.verify(payCieloServiceProvider, times(1)).pay(paymentRequest);
        inOrder.verifyNoMoreInteractions();

        assertEquals(expectedPaymentResponsePayed(), paymentResponse);
    }

    @Test
    public void testPayVisa() throws Exception {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCardNumber("6545645645645");
        paymentRequest.setFlag(FlagEnum.VISA);

        when(payVisaServiceProvider.pay(paymentRequest)).thenReturn(expectedPaymentResponsePayed());

        PaymentResponse paymentResponse = payVisaServiceProvider.pay(paymentRequest);

        InOrder inOrder = inOrder(payVisaServiceProvider);
        inOrder.verify(payVisaServiceProvider, times(1)).pay(paymentRequest);
        inOrder.verifyNoMoreInteractions();

        assertEquals(expectedPaymentResponsePayed(), paymentResponse);
    }

    private PaymentResponse expectedPaymentResponsePayed() {
        return  new PaymentResponse(true);
    }
}