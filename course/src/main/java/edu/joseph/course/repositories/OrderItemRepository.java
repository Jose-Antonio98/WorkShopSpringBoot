package edu.joseph.course.repositories;

import edu.joseph.course.entites.OrderItem;
import edu.joseph.course.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
