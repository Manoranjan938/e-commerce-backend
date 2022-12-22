package com.example.eCommDemo.repository;

import com.example.eCommDemo.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query(value = "select\n" +
            "\to.id,\n" +
            "\to.order_date,\n" +
            "\to.delivery_date\n" +
            "from\n" +
            "\torders o\n" +
            "WHERE\n" +
            "\to.order_by=:userId", nativeQuery = true)
    public List<Object> getOrdersByUserId(Long userId);

    @Query(value = "select\n" +
            "\tdelivery_date,\n" +
            "\torder_date,\n" +
            "\torder_city,\n" +
            "\torder_dist,\n" +
            "\tu.phone,\n" +
            "\torder_landmark,\n" +
            "\torder_pincode,\n" +
            "\torder_state,\n" +
            "\torder_street,\n" +
            "\ttotal_price\n" +
            "from\n" +
            "\torders o\n" +
            "JOIN users u on\n" +
            "\tu.id = o.order_by\n" +
            "WHERE\n" +
            "\to.id=:orderId", nativeQuery = true)
    public List<Object> getOrderDetailsByOrderId(Long orderId);

}
