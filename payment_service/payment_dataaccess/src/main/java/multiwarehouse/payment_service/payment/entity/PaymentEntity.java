package multiwarehouse.payment_service.payment.entity;

import java.util.UUID;
import java.util.Objects;

import lombok.*;

// import multiwarehouse.domain.valueobject.PaymentMethod;
// import multiwarehouse.domain.valueobject.PaymentStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
@Entity
public class PaymentEntity {
    @Id
    private UUID id;
    private UUID referenceId;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private String failedMessage;
    private Money amount;
    private CreatedAt createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}   