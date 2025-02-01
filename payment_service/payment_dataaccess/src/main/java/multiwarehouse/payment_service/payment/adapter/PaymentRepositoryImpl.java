package multiwarehouse.payment_service.payment.adapter;

import java.util.Optional;
import java.util.UUID;

import multiwarehouse.payment_service.payment.repository.PaymentDataAccessMapper;
import multiwarehouse.payment_service.payment.repository.PaymentJpaRepository;
import multiwarehouse.payment_service.ports.output.repository.PaymentRepository;

import org.springframework.stereotype.Component;

@Component
public class PaymentRepositoryImpl implements PaymentRepository {
    private final PaymentJpaRepository paymentJpaRepository;
    private final PaymentDataAccessMapper paymentDataAccessMapper;

    public PaymentRepositoryImpl(PaymentJpaRepository paymentJpaRepository, PaymentDataAccessMapper paymentDataAccessMapper) {
        this.paymentJpaRepository = paymentJpaRepository;
        this.paymentDataAccessMapper = paymentDataAccessMapper;
    }

    @Override
    public Payment save(Payment payment) {
        return paymentDataAccessMapper.paymentEntityToPayment(paymentJpaRepository.save(paymentDataAccessMapper.paymentToPaymentEntity(payment)));
    }

    @Override
    public Optional<Payment> findByReferenceId(UUID paymentId) {
        return paymentJpaRepository.findByReferenceId(paymentId).map(paymentDataAccessMapper::paymentEntityToPayment);
    }
}