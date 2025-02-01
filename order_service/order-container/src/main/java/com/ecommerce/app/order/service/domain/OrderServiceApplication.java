package multiwarehouse.ecommerce.order.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "multiwarehouse.ecommerce.order.service.dataaccess", "multiwarehouse.ecommerce.dataaccess" })
@EntityScan(basePackages = { "multiwarehouse.ecommerce.order.service.dataaccess", "multiwarehouse.ecommerce.dataaccess"})
@SpringBootApplication(scanBasePackages = "multiwarehouse.ecommerce")
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}