package com.tc.tacocloud.model.data;

import com.tc.tacocloud.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
