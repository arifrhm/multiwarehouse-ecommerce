package multiwarehouse.payment_service.payment_container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages={"multiwarehouse.payment_service.payment.dataaccess"})
@EntityScan(basePackages={"multiwarehouse.payment_service.payment.dataaccess"})
@SpringBootApplication(scanBasePackages = {"multiwarehouse.payment_service"})
public class PaymentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}
