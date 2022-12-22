package com.example.eCommDemo.repository;

import com.example.eCommDemo.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {

    @Query(value = "select * from order_items oi WHERE oi.order_id=:id", nativeQuery = true)
    public List<OrderItems> getDetailsByOderId(Long id);

}
