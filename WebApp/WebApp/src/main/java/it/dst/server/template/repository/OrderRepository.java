package it.dst.server.template.repository;

import it.dst.server.template.object.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
