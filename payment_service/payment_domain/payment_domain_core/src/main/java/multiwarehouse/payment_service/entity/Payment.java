package multiwarehouse.payment_service.entity;

import java.util.UUID;

import multiwarehouse.common.domain.entity.AggregateRoot;
import multiwarehouse.common.domain.valueobject.*;
import multiwarehouse.payment_service.valueobject.FailedMessage;
import multiwarehouse.payment_service.valueobject.PaymentMethod;
import multiwarehouse.payment_service.valueobject.PaymentStatus;
import multiwarehouse.payment_service.valueobject.ReferenceId;

public class Payment extends AggregateRoot<PaymentId> {
    private final ReferenceId referenceId;

    private final PaymentMethod paymentMethod;

    private PaymentStatus paymentStatus;

    private final FailedMessage failedMessage;

    private final Money amount;

    private final CreatedAt createdAt;

    public void initializePayment() {
        setId(new PaymentId(UUID.randomUUID()));  
        paymentStatus = PaymentStatus.ONPROCESS;
    }

    public void updatePayment() {
        if (amountEquals(amount) && referenceIdEquals(referenceId)) {
            paymentStatus = PaymentStatus.SUCCESS;
        } else {
            paymentStatus = PaymentStatus.FAILED;
        }
    }

    private boolean referenceIdEquals(ReferenceId referenceId) {
        return this.referenceId.equals(referenceId);
    }

    private boolean amountEquals(Money moneyPaid) {
        return amount.equals(moneyPaid);
    }

    public void successPaid() {
        paymentStatus = PaymentStatus.SUCCESS;
    }

    public void failedPaid() {
        paymentStatus = PaymentStatus.FAILED;
    }

    private Payment(Builder builder) {
        super.setId(builder.paymentId);
        referenceId = builder.referenceId;
        paymentMethod = builder.paymentMethod;
        paymentStatus = builder.paymentStatus;
        failedMessage = builder.failedMessage;
        amount = builder.amount;
        createdAt = builder.createdAt;
    }   

    public static Builder builder() {
        return new Builder();
    }

    public ReferenceId getReferenceId() {
        return referenceId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public FailedMessage getFailedMessage() {
        return failedMessage;
    }

    public Money getAmount() {
        return amount;
    }

    public CreatedAt getCreatedAt() {
        return createdAt;
    }

    private static class Builder {
        private PaymentId paymentId;
        private ReferenceId referenceId;
        private PaymentMethod paymentMethod;
        private PaymentStatus paymentStatus;
        private FailedMessage failedMessage;
        private Money amount;
        private CreatedAt createdAt;

        private Builder() {
        }

        private Payment build() {
            return new Payment(this);
        }

        private Builder paymentId(PaymentId val) {
            paymentId = val;
            return this;
        }

        private Builder referenceId(ReferenceId val) {
            referenceId = val;
            return this;
        }

        private Builder paymentMethod(PaymentMethod val) {
            paymentMethod = val;
            return this;
        }

        private Builder paymentStatus(PaymentStatus val) {
            paymentStatus = val;
            return this;
        }

        private Builder failedMessage(FailedMessage val) {
            failedMessage = val;
            return this;
        }

        private Builder amount(Money val) {
            amount = val;
            return this;
        }

        private Builder createdAt(CreatedAt val) {
            createdAt = val;
            return this;
        }
    }
}
