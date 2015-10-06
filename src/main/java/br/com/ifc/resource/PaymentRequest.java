package br.com.ifc.resource;

import br.com.ifc.enums.FlagEnum;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * The type Payment request.
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@XmlRootElement
public class PaymentRequest implements Serializable {

    private String cardNumber;
    private FlagEnum flag;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(final String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public FlagEnum getFlag() {
        return flag;
    }

    public void setFlag(final FlagEnum flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(final Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
