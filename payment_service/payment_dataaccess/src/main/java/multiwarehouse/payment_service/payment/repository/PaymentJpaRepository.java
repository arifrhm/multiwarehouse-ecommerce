package multiwarehouse.payment_service.payment.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import multiwarehouse.payment_service.payment.entity.PaymentEntity;

@Repository
public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, UUID> {
    Optional<PaymentEntity> findByReferenceId(UUID paymentId);
}