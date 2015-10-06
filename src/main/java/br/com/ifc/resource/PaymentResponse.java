package br.com.ifc.resource;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * The type Payment response.
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@XmlRootElement
public class PaymentResponse implements Serializable {

    private Boolean approved;

    public PaymentResponse() {}

    public PaymentResponse(final Boolean approved) {
        this.approved = approved;
    }

    public void setApproved(final Boolean approved) {
        this.approved = approved;
    }

    public Boolean getApproved() {
        return approved;
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
